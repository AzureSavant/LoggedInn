package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.TravelerMapper;
import com.azure.LoggedInn.models.Traveler;
import com.azure.LoggedInn.repositories.TravelerRepository;
import com.azure.LoggedInn.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.InputMismatchException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;
    private final PasswordEncoder passwordEncoder;
    private final TravelerMapper travelerMapper;

    @Override
    public Traveler getTravelerByEmail(String email) {
        return this.travelerRepository.getTravelerByEmail(email);
    }

    @Override
    public Traveler getTravelerById(long id) {
        return this.travelerRepository.getTravelerById(id);
    }

    @Override
    public Traveler saveTraveler(Traveler traveler){
        String encodedPassword = passwordEncoder.encode(traveler.getPassword());
        traveler.setPassword(encodedPassword);

        return this.travelerRepository.save(traveler);
    }

    @Override
    public List<Traveler> getAll() {

        return this.travelerRepository.findAll();
    }

    @Override
    public Traveler updateTraveler(long id, Traveler newTraveler) {
        Traveler  repoTraveler = this.travelerRepository.getTravelerById(id);
        travelerMapper.customMapTraveler(repoTraveler,newTraveler);

        return this.travelerRepository.save(repoTraveler);
    }

    @Override
    public void deleteTraveler(long id) {
        this.travelerRepository.deleteById(id);
    }

    @Override
    public void deleteTraveler(@NotNull Traveler traveler) {
        Traveler repoTraveler = this.travelerRepository.getTravelerByEmail(traveler.getEmail());

        this.travelerRepository.delete(repoTraveler);
    }

    @Override
    public void updateTravelerPassword(long id, String oldPassword, String newPassword) {
        Traveler traveler = this.travelerRepository.getTravelerById(id);

        if(passwordEncoder.matches(oldPassword, traveler.getPassword())){
            traveler.setPassword(passwordEncoder.encode(newPassword));
            this.travelerRepository.save(traveler);
        }
        else
            throw new InputMismatchException("Passwords do not match.");
    }
}
