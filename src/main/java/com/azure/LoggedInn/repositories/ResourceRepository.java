package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Optional<Resource> getFirstById(long id);

    Optional<Resource> getFirstByAddress(String address);

    List<Resource> getAllByOwner(User owner);

    List<Resource> getAllByCity(String city);
    void deleteById(long id);

}
