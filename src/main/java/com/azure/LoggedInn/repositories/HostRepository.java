package com.azure.LoggedInn.repositories;

import com.azure.LoggedInn.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
    Host getFirstById(long id);

    Host getFirstByEmail (String Email);

}
