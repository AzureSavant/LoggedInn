package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.Traveler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceService {

    Resource getResourceById(long id);

    Resource saveResource(Resource resource);

    List<Resource> getAll();

    Resource updateResource(long id, Resource newResource);

    void  deleteResource(long id);

    void  deleteResource(Resource resource);

    void  updateResourcePassword(long id, String oldPassword, String newPassword);
}
