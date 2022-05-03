package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.ResourceMapper;
import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.repositories.ResourceRepository;
import com.azure.LoggedInn.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceMapper resourceMapper;
    private final ResourceRepository resourceRepository;
    private final UserServiceImpl userService;

    @Override
    public Resource getResourceById(long id) {
        return this.resourceRepository.getFirstById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resource Not Found"));
    }

    @Override
    public Resource createResource(Resource resource) {
        userService.addUserResource(resource.getOwner().getId(), resource);
        return this.resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public List<Resource> getAllByOwner(User owner) {
        return this.resourceRepository.getAllByOwner(owner);
    }

    @Override
    public Resource updateResource(long id, Resource newResource) {
        Resource repoResource = getResourceById(id);
        resourceMapper.customMapResource(repoResource, newResource);

        return this.resourceRepository.save(repoResource);
    }

    @Override
    public void deleteResource(long id) {
        this.resourceRepository.deleteById(id);
    }

    @Override
    public void deleteResource(Resource resource) {
        //To be implemented or removed
    }

}
