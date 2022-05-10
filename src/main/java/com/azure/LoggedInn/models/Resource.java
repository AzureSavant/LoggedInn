package com.azure.LoggedInn.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource", schema = "public")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "resource_type", nullable = false)
    private String resourceType;


    @Column(name = "extras")
    private String extras;

    @NotNull
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    public Resource(@NotEmpty String name, String description, @NotEmpty String resourceType, String extras) {
        this.name = name;
        this.description = description;
        this.resourceType = resourceType;
        this.extras = extras;
    }

    public Resource(String name, String description, String resourceType, String extras, String address, String city) {
        this.name = name;
        this.description = description;
        this.resourceType = resourceType;
        this.extras = extras;
        this.address = address;
        this.city = city;
    }

    public Resource(String name, String description, String resourceType, String extras, String address, String city, User owner) {
        this.name = name;
        this.description = description;
        this.resourceType = resourceType;
        this.extras = extras;
        this.address = address;
        this.city = city;
        this.owner = owner;
    }
}
