package com.AbAmAk.Pompa.entity;

import com.AbAmAk.Pompa.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password; // Should be hashed using a strong algorithm (e.g., bcrypt)

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    // Add a getter and setter for birthdate (assuming it's a mandatory field)
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

}

