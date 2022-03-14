package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.UserMapper;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.repositories.UserRepository;
import com.azure.LoggedInn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User getUserByEmail(String email) {

        return this.userRepository.getFirstByEmail(email);
    }

    @Override
    public User getUserById(long id) {

        return this.userRepository.getFirstById(id);
    }

    @Override
    public List<User> getAll() {

        return this.userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(long id, User newUser) {
        User repoUser = this.userRepository.getFirstById(id);
        userMapper.customMapUser(repoUser, newUser);


        return this.userRepository.save(repoUser);
    }


    @Override
    public void updateUserPassword(long id, String oldPassword, String newPassword) {
        User user = this.userRepository.getById(id);

        if(passwordEncoder.matches(oldPassword, user.getPassword())){
            String encodedPasswordNew = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPasswordNew);

           this.userRepository.save(user);
        }
        else
            throw new InputMismatchException("Passwords do not match.");
    }

    @Override
    public void updateUserEmail(String oldEmail, String newEmail) {
        User repoUser = this.userRepository.getFirstByEmail(oldEmail);

        repoUser.setEmail(newEmail);

        this.userRepository.save(repoUser);
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        User repoUser = this.userRepository.getFirstByEmail(user.getEmail());

        this.userRepository.delete(repoUser);
    }



}
