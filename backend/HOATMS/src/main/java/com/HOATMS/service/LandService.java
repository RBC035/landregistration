package com.HOATMS.service;

import com.HOATMS.model.Land;
import com.HOATMS.repository.LandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandService {

    private final LandRepository landRepository;

    public LandService(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    public List<Land> getAllLands() {
        return landRepository.findAll();
    }

    public Optional<Land> getLandById(String landId) {
        return landRepository.findByLandId(landId);
    }

    public List<Land> getLandsByOwnerId(String ownerId) {
        return landRepository.findByOwnerId(ownerId);
    }

    public Land createLand(Land land) {
        return landRepository.save(land);
    }

    public Land updateLand(String landId, Land landDetails) {
        return landRepository.findByLandId(landId).map(land -> {
            land.setRegisterBy(landDetails.getRegisterBy());
            land.setSize(landDetails.getSize());
            land.setWard(landDetails.getWard());
            land.setLandUse(landDetails.getLandUse());
            land.setRegisterDate(landDetails.getRegisterDate());
            land.setDistrict(landDetails.getDistrict());
            land.setRegion(landDetails.getRegion());
            land.setOwnerId(landDetails.getOwnerId());
            land.setLatitude(landDetails.getLatitude());
            land.setLongitude(landDetails.getLongitude());
            return landRepository.save(land);
        }).orElseThrow(() -> new RuntimeException("Land not found with id " + landId));
    }

    public void deleteLand(String landId) {
        landRepository.deleteById(landId);
    }
}
