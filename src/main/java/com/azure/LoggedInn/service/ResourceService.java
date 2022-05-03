package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceService {

    Resource getResourceById(long id);

    Resource createResource(Resource resource);

    List<Resource> getAll();

    List<Resource> getAllByOwner(User owner);

    Resource updateResource(long id, Resource newResource);

    void  deleteResource(long id);

    void  deleteResource(Resource resource);

}
