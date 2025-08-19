package com.HOATMS.repository;

import com.HOATMS.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandRepository extends JpaRepository<Land, String> {
    Optional<Land> findByLandId(String landId);
    List<Land> findByOwnerId(String ownerId);
}
