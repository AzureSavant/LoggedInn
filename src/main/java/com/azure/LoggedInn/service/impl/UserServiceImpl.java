package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.UserMapper;
import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.repositories.RoleRepository;
import com.azure.LoggedInn.repositories.UserRepository;
import com.azure.LoggedInn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.getFirstByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found"));
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.getFirstById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found"));
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = getUserByEmail(email);
        Role role = this.roleRepository.findRoleByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
        user.getRoles().add(role);

        this.userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
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
        User repoUser = getUserById(id);
        userMapper.customMapUser(repoUser, newUser);

        return this.userRepository.save(repoUser);
    }


    @Override
    public void updateUserPassword(long id, String oldPassword, String newPassword) {
        User user = getUserById(id);

        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            String encodedPasswordNew = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPasswordNew);

            this.userRepository.save(user);
        } else
            throw new InputMismatchException("Passwords do not match.");
    }

    @Override
    public void updateUserEmail(String oldEmail, String newEmail) {
        User repoUser = getUserByEmail(oldEmail);
        repoUser.setEmail(newEmail);

        this.userRepository.save(repoUser);
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        User repoUser = getUserByEmail(user.getEmail());

        this.userRepository.delete(repoUser);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getUserByEmail(email);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
