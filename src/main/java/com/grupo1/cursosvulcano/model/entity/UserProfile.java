package com.grupo1.cursosvulcano.model.entity;

import java.time.LocalDate;

import com.grupo1.cursosvulcano.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile extends BaseEntity {

    //@OneToOne(fetch = FetchType.LAZY)
    //@MapsId // Indica que el ID de esta entidad se deriva de la entidad User
    //@JoinColumn(name = "user_id")
    //private User user;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profilePictureUrl; // Ruta al almacenamiento (S3, Cloudinary, etc.)

    private LocalDate birthDate;

    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

}
