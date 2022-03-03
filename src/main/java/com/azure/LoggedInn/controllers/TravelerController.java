package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.TravelerDTO;
import com.azure.LoggedInn.mappers.TravelerMapper;
import com.azure.LoggedInn.models.Traveler;
import com.azure.LoggedInn.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/traveler")
@RequiredArgsConstructor
public class TravelerController {

    private final TravelerService travelerService;
    private final TravelerMapper travelerMapper;

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<Traveler> getTravelers(){
        return this.travelerService.getAll();
    }

    @GetMapping(params = "id")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Traveler getTravelerById(@RequestParam("id") long id){
        return this.travelerService.getTravelerById(id);
    }

    @PostMapping( "/register")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Traveler createTraveler(@RequestBody @Valid Traveler traveler){
        return this.travelerService.saveTraveler(traveler);
    }

    @PutMapping(value = "/update", params = "id")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Traveler updateTraveler(@RequestParam("id") long id, @RequestBody @Valid TravelerDTO newTravelerDTO){
        Traveler  newTraveler = travelerMapper.DTOtoTraveler(newTravelerDTO);
        return this.travelerService.updateTraveler(id, newTraveler);
    }


    @DeleteMapping(value = "/delete", params = "id")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTraveler(@RequestParam("id") long id){
        this.travelerService.deleteTraveler(id);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTraveler(@RequestBody TravelerDTO travelerDTO){
        Traveler traveler = travelerMapper.DTOtoTraveler(travelerDTO);
        this.travelerService.deleteTraveler(traveler);
    }
}
