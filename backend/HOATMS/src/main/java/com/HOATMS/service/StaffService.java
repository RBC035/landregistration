package com.HOATMS.service;

import com.HOATMS.model.Staff;
import com.HOATMS.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    public Optional<Staff> getStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staffDetails) {
        return staffRepository.findById(id).map(staff -> {
            staff.setFullName(staffDetails.getFullName());
            staff.setPosition(staffDetails.getPosition());
            staff.setPhone(staffDetails.getPhone());
            staff.setEmail(staffDetails.getEmail());
            staff.setStatus(staffDetails.getStatus());
            return staffRepository.save(staff);
        }).orElseThrow(() -> new RuntimeException("Staff not found with id " + id));
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
