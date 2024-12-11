package com.example.MuhanParking.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "T2_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String gender;

    @Column(name = "student_id", nullable = false, unique = true)
    private Integer studentId;

    @Column(nullable = false)
    private Integer department;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;  // 기본값 USER로 설정

    @Column(name = "notification_enabled")
    private boolean notificationEnabled = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACTIVE;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public User(String username,  String email, String password, String name, String phone,
                String address, String gender, Integer studentId,
                Integer department, String birthDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.studentId = studentId;
        this.department = department;
        this.birthDate = birthDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updatePhone(String newPhone) {
        this.phone = newPhone;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    public void updateNotificationEnabled(boolean enabled) {
        this.notificationEnabled = enabled;
    }

    public void updateStatus(Status status) {  // 이것도 추가하면 좋을 것 같아
        this.status = status;
    }

}