package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.EmailDTO;
import com.azure.LoggedInn.dto.UserDTO;
import com.azure.LoggedInn.mappers.UserMapper;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.service.UserService;
import com.azure.LoggedInn.shared.RoleNameConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
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
     public List<UserDTO> getUsers(){

          List<User> users= userService.getAllWithRole(RoleNameConst.HOST);
          List<UserDTO> userDTOS = new ArrayList<>();
          users.forEach(user -> userDTOS.add(userMapper.UserToDTO(user)));
          return userDTOS;
     }

     @GetMapping(params ="id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public UserDTO getUserById(@RequestParam("id") long id){
          User repoUser = userService.getUserById(id);
          return userMapper.UserToDTO(repoUser);
     }

     @PostMapping("/register")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.CREATED)
     public User createUser(@RequestBody @Valid UserDTO userDTO){
          User user = userMapper.DTOtoUser(userDTO);

          return this.userService.createUser(
                  user);
     }

     @PutMapping(value = "/update",params = "id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public User updateUser(@RequestParam("id") long id, @RequestBody @Valid UserDTO newUserDTO){
          User newUser = userMapper.DTOtoUser(newUserDTO);

          return this.userService.updateUserById(id, newUser);
     }


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
