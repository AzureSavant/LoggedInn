package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
    Resource getFirstById(Resource resource);


}
