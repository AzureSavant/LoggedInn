package com.azure.LoggedInn.service;

import com.azure.LoggedInn.models.Host;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostService {

    Host getUserByEmail(String email);

    Host getUserById (long id);

    List<Host> getAll();

    Host saveHost(Host host);

    Host updateHost(long id, Host newHost);

    void updateHostPassword(long id, String oldPassword, String newPassword);

    void updateHostEmail(String oldEmail, String newEmail);

    void deleteHost(long id);

    void deleteHost(Host host);
}
