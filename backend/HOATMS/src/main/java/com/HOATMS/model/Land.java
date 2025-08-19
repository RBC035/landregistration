package com.HOATMS.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "land")
public class Land {

    @Id
    @Column(name = "land_id", nullable = false, unique = true, length = 20)
    private String landId;

    private String registerBy;
    private String size;
    private String ward;
    private String shehia; 
    private String landUse;

    @Column(name = "register_date")
    private LocalDate registerDate;

    private String district;
    private String region;

    private Double latitude;
    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String shape;

    @Column(name = "owner_id", nullable = false)
    private String ownerId;

    // --- Constructors ---
    public Land() {}

    public Land(String landId, String registerBy, String size, String ward, String shehia,
                String landUse, LocalDate registerDate, String district, String region,
                Double latitude, Double longitude, String shape, String ownerId) {
        this.landId = landId;
        this.registerBy = registerBy;
        this.size = size;
        this.ward = ward;
        this.shehia = shehia;
        this.landUse = landUse;
        this.registerDate = registerDate;
        this.district = district;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
        this.shape = shape;
        this.ownerId = ownerId;
    }

    // --- Getters & Setters ---
    public String getLandId() { return landId; }
    public void setLandId(String landId) { this.landId = landId; }

    public String getRegisterBy() { return registerBy; }
    public void setRegisterBy(String registerBy) { this.registerBy = registerBy; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public String getShehia() { return shehia; }
    public void setShehia(String shehia) { this.shehia = shehia; }

    public String getLandUse() { return landUse; }
    public void setLandUse(String landUse) { this.landUse = landUse; }

    public LocalDate getRegisterDate() { return registerDate; }
    public void setRegisterDate(LocalDate registerDate) { this.registerDate = registerDate; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }

    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
}
