package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getFirstById(long id);

    Optional<User> getFirstByEmail(String Email);

}
