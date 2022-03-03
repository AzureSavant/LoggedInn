package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Traveler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerService {
    Traveler getTravelerByEmail(String email);

    Traveler getTravelerById(long id);

    Traveler saveTraveler(Traveler traveler);

    List<Traveler> getAll();

    Traveler updateTraveler(long id, Traveler newTraveler);

    void  deleteTraveler (long id);

    void  deleteTraveler (Traveler traveler);

    void  updateTravelerPassword(long id, String oldPassword, String newPassword);
}
