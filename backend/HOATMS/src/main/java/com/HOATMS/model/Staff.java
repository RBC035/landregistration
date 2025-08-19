package com.HOATMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String position;

    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    private String status;

    // --- Constructors ---
    public Staff() {}

    public Staff(Long id, String fullName, String position, String phone, String email, String status) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
