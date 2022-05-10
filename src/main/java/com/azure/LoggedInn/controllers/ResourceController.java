package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.ResourceDTO;
import com.azure.LoggedInn.mappers.ResourceMapper;
import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.service.ResourceService;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;
    private final ResourceMapper resourceMapper;

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    List<ResourceDTO> getResources() {
        List<Resource> resources = this.resourceService.getAll();
        List<ResourceDTO> resourceDTOS = new ArrayList<>();
        resources.forEach(resource -> resourceDTOS.add(resourceMapper.resourceToDTO(resource)));
        return resourceDTOS;
    }

    @GetMapping(value = "/owner", params = "id")
    List<ResourceDTO> getResourcesByOwner(@RequestParam("id") long id){
        List<Resource> resources = this.resourceService.getAllByOwnerId(id);
        List<ResourceDTO> resourceDTOS = new ArrayList<>();
        resources.forEach(resource -> resourceDTOS.add(resourceMapper.resourceToDTO(resource)));
        return resourceDTOS;
    }
}
