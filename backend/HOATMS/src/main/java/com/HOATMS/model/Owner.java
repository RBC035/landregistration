package com.HOATMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String zanID;

    @Column(nullable = false)
    private String fullName;

    private String ownerType;
    private String phone;
    private String address;
    private String status;

    // --- Constructors ---
    public Owner() {}

    public Owner(Long id, String zanID, String fullName, String ownerType, String phone, String address, String status) {
        this.id = id;
        this.zanID = zanID;
        this.fullName = fullName;
        this.ownerType = ownerType;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getZanID() { return zanID; }
    public void setZanID(String zanID) { this.zanID = zanID; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getOwnerType() { return ownerType; }
    public void setOwnerType(String ownerType) { this.ownerType = ownerType; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
