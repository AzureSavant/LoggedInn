package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {
    Traveler getTravelerById(long id);

    Traveler getTravelerByEmail(String email);
}
