package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.EmailDTO;
import com.azure.LoggedInn.dto.UserDTO;
import com.azure.LoggedInn.mappers.UserMapper;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/user/host")
@RequiredArgsConstructor
public class HostController {

     private final UserService userService;
     private final UserMapper userMapper;

     @GetMapping
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public List<User> getUsers(){

          return userService.getAll();
     }

     @GetMapping(params ="id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public User getUserById(@RequestParam("id") long id){
          return userService.getUserById(id);
     }

     @PostMapping("/register")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.CREATED)
     public User createUser(@RequestBody @Valid UserDTO userDTO){
          User user = userMapper.DTOtoUser(userDTO);

          return this.userService.saveUser(user);
     }


     @PutMapping(value = "/update",params = "id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public User updateUser(@RequestParam("id") long id, @RequestBody @Valid UserDTO newUserDTO){
          User newUser = userMapper.DTOtoUser(newUserDTO);

          return this.userService.updateUser(id, newUser);
     }

     // This might not be needed...
     @PutMapping(value = "/update")
     @ResponseStatus(code = HttpStatus.OK)
     public void updateUserEmail(@RequestBody @Valid EmailDTO emailDTO){
          this.userService.updateUserEmail(emailDTO.getOldEmail(), emailDTO.getNewEmail());
     }

     @DeleteMapping(value = "/delete", params = "id")
     @ResponseStatus(code = HttpStatus.OK )
     public void deleteUserById(@RequestParam("id") long id){
          this.userService.deleteUser(id);
     }

     @DeleteMapping(value = "/delete")
     @ResponseStatus(code = HttpStatus.OK)
     public void deleteUser(@RequestBody @Valid UserDTO userDTO){
          User user = userMapper.DTOtoUser(userDTO);
          this.userService.deleteUser(user);
     }

}
