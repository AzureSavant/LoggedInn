package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceService {

    Resource getResourceById(long id);

    Resource createResource(Resource resource);

    List<Resource> getAll();

    List<Resource> getAllByOwnerId( long id);

    Resource updateResource(long id, Resource newResource);

    void  deleteResource(long id);

}
