package com.HOATMS.controller;

import com.HOATMS.model.Land;
import com.HOATMS.service.LandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/lands")
public class LandController {

    private final LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    } 

    @GetMapping
    public List<Land> getAllLands() {
        return landService.getAllLands();
    }

    @GetMapping("/{landId}")
    public ResponseEntity<Land> getLandById(@PathVariable String landId) {
        return landService.getLandById(landId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/owner/{ownerId}")
    public List<Land> getLandsByOwnerId(@PathVariable String ownerId) {
        return landService.getLandsByOwnerId(ownerId);
    }

    @PostMapping
    public Land createLand(@RequestBody Land land) {
        return landService.createLand(land);
    }

    @PutMapping("/{landId}")
    public ResponseEntity<Land> updateLand(@PathVariable String landId, @RequestBody Land landDetails) {
        try {
            Land updated = landService.updateLand(landId, landDetails);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{landId}")
    public ResponseEntity<Void> deleteLand(@PathVariable String landId) {
        landService.deleteLand(landId);
        return ResponseEntity.noContent().build();
    }
}
