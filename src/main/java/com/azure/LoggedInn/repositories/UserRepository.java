package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getFirstById(long id);

    Optional<User> getFirstByEmail(String Email);

    List<User> getAllByRolesIn(Collection<Role> roles);
    }
