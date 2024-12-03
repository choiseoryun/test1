package com.example.MuhanParking.api.user.repository;

import com.example.MuhanParking.api.user.model.RegularParkingApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegularParkingApplicationRepository extends JpaRepository<RegularParkingApplication, Long> {
    List<RegularParkingApplication> findByUserId(Long userId);
    Optional<RegularParkingApplication> findByUserIdAndApplicationStatus(Long userId, RegularParkingApplication.ApplicationStatus status);
    List<RegularParkingApplication> findByApplicationStatus(RegularParkingApplication.ApplicationStatus status);
}