package com.azure.LoggedInn.models;

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
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;


    @Column(name = "description",nullable = false)
    private String description;

    @NotNull
    @Column(name = "resource_type",nullable = false)
    private String resourceType;


    @Column(name = "extras")
    private String extras;

    //TODO: Implement relations between User,  ResourceRating, Rent, ResourceLocation
    public Resource(@NotEmpty String name, String description, @NotEmpty String resourceType, String extras) {
        this.name = name;
        this.description = description;
        this.resourceType = resourceType;
        this.extras = extras;
    }
}
