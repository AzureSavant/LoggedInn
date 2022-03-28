package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    User getUserByEmail(String email);

    User getUserById (long id);

    void addRoleToUser(String email, String roleName);

    Role saveRole(Role role);

    List<User> getAll();

    User saveUser(User user);

    User updateUser(long id, User newUser);

    void updateUserPassword(long id, String oldPassword, String newPassword);

    void updateUserEmail(String oldEmail, String newEmail);

    void deleteUser(long id);

    void deleteUser(User user);
}
