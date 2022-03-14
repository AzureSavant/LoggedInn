package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.ResourceMapper;
import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.repositories.ResourceRepository;
import com.azure.LoggedInn.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceMapper resourceMapper;
    private final ResourceRepository resourceRepository;

    @Override
    public Resource getResourceById(long id) {
        return null;
    }

    @Override
    public Resource saveResource(Resource resource) {
        return null;
    }

    @Override
    public List<Resource> getAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public Resource updateResource(long id, Resource newResource) {
        return null;
    }

    @Override
    public void deleteResource(long id) {

    }

    @Override
    public void deleteResource(Resource resource) {

    }

    @Override
    public void updateResourcePassword(long id, String oldPassword, String newPassword) {

    }
}
