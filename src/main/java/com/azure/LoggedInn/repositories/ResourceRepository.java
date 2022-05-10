package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Optional<Resource> getFirstById(long id);

    Optional<Resource> getFirstByAddress(String address);
    @Query("SELECT r FROM Resource  r WHERE r.owner.id = :id")
    List<Resource> getAllByOwnerId(@Param("id") long id);

    List<Resource> getAllByCity(String city);
    void deleteById(long id);

}
