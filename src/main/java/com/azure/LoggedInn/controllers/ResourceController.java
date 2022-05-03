package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.mappers.ResourceMapper;
import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    List<Resource> getResources(){
        return this.resourceService.getAll();
    }
}
