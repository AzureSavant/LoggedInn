package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    User getUserByEmail(String email);

    User getUserById (long id);

    void addRoleToUser(String email, String roleName);

    void saveRole(Role role);

    Role findRoleByName(String roleName);

    List<User> getAll();

    List<User> getAllWithRole(String Role);

    User createUser(User user);

    User updateUserById(long id, User newUser);

    User updateUserByEmail(String email, User newUser);

    void updateUserPassword(long id, String oldPassword, String newPassword);

    void updateUserEmail(String oldEmail, String newEmail);

    void deleteUser(long id);

    void deleteUser(User user);

    void addUserResource(long id,Resource resource);
}
