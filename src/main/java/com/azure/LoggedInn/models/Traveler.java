package com.azure.LoggedInn.models;

import com.azure.LoggedInn.shared.ValidationConstraints;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "traveler", schema = "public")
public class Traveler {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname",nullable = false)
    private String surname;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Email(regexp = ValidationConstraints.EMAIL_REGEX)
    @Column(name = "email", nullable = false, unique = true)
    private String email;


    public Traveler( String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }
}
