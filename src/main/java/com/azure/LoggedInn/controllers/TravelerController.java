package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.UserDTO;
import com.azure.LoggedInn.mappers.UserMapper;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.service.UserService;
import com.azure.LoggedInn.shared.RoleNameConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user/traveler")
@RequiredArgsConstructor
public class TravelerController {

    private final UserService UserService;
    private final UserMapper UserMapper;

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUsers(){

        return this.UserService.getAllWithRole(RoleNameConst.TRAVELER);
    }

    @GetMapping(params = "id")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserById(@RequestParam("id") long id){
        return this.UserService.getUserById(id);
    }

    @PostMapping( "/register")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User User){
        return this.UserService.createUser(User);
    }

    @PutMapping(value = "/update", params = "id")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public User updateUser(@RequestParam("id") long id, @RequestBody @Valid UserDTO newUserDTO){
        User  newUser = UserMapper.DTOtoUser(newUserDTO);
        return this.UserService.updateUser(id, newUser);
    }


    @DeleteMapping(value = "/delete", params = "id")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteUser(@RequestParam("id") long id){
        this.UserService.deleteUser(id);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteUser(@RequestBody UserDTO UserDTO){
        User User = UserMapper.DTOtoUser(UserDTO);
        this.UserService.deleteUser(User);
    }
}
