package com.HOATMS.service;

import com.HOATMS.model.Owner;
import com.HOATMS.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    public Optional<Owner> getOwnerByZanID(String zanID) {
        return ownerRepository.findByZanID(zanID);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Long id, Owner ownerDetails) {
        return ownerRepository.findById(id).map(owner -> {
            owner.setZanID(ownerDetails.getZanID());
            owner.setFullName(ownerDetails.getFullName());
            owner.setOwnerType(ownerDetails.getOwnerType());
            owner.setPhone(ownerDetails.getPhone());
            owner.setAddress(ownerDetails.getAddress());
            owner.setStatus(ownerDetails.getStatus());
            return ownerRepository.save(owner);
        }).orElseThrow(() -> new RuntimeException("Owner not found with id " + id));
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
