package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getFirstById(long id);

    User getFirstByEmail(String Email);

}
