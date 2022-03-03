package com.azure.LoggedInn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResourceDTO {

    private String name;


    private String description;


    private String resourceType;


    private String extras;

}
