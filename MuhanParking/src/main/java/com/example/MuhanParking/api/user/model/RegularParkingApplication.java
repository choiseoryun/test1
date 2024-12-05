package com.example.MuhanParking.api.user.model;

import com.example.MuhanParking.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "T2_REGULAR_PARKING_APPLICATION")
@Getter
@Setter
@NoArgsConstructor
public class RegularParkingApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "student_year", nullable = false)
    private Integer studentYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "transportation_type", nullable = false)
    private TransportationType transportationType;

    @Column(name = "departure_station", nullable = false)
    private String departureStation;

    @Column(name = "station_time_minutes", nullable = false)
    private Integer stationTimeMinutes;

    @Column(name = "public_transport_time", nullable = false)
    private Integer publicTransportTime;

    @Column(name = "car_time", nullable = false)
    private Integer carTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status", nullable = false)
    private ApplicationStatus applicationStatus = ApplicationStatus.PENDING;

    @Column(name = "evaluation_score")
    private Integer evaluationScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private ParkingLot parkingLot;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Enum classes
    public enum TransportationType {
        BUS, SUBWAY
    }

    public enum ApplicationStatus {
        PENDING,
        APPROVED,
        REJECTED,
        DOCUMENT_REQUIRED,
        PAYMENT_REQUIRED,
        COMPLETED
    }
}