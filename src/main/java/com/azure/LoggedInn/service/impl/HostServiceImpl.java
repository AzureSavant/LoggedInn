package com.azure.LoggedInn.service.impl;

import com.azure.LoggedInn.mappers.HostMapper;
import com.azure.LoggedInn.models.Host;
import com.azure.LoggedInn.repositories.HostRepository;
import com.azure.LoggedInn.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final PasswordEncoder passwordEncoder;
    private final HostMapper hostMapper;

    @Override
    public Host getUserByEmail(String email) {

        return this.hostRepository.getFirstByEmail(email);
    }

    @Override
    public Host getUserById(long id) {

        return this.hostRepository.getFirstById(id);
    }

    @Override
    public List<Host> getAll() {

        return this.hostRepository.findAll();
    }

    @Override
    public Host saveHost(Host host) {
        String encodedPassword = passwordEncoder.encode(host.getPassword());
        host.setPassword(encodedPassword);

        return this.hostRepository.save(host);
    }

    @Override
    public Host updateHost(long id,Host newHost) {
        Host  repoHost = this.hostRepository.getFirstById(id);
        hostMapper.customMapHost(repoHost, newHost);


        return this.hostRepository.save(repoHost);
    }


    @Override
    public void updateHostPassword(long id, String oldPassword, String newPassword) {
        Host host = this.hostRepository.getById(id);

        if(passwordEncoder.matches(oldPassword, host.getPassword())){
            String encodedPasswordNew = passwordEncoder.encode(newPassword);
            host.setPassword(encodedPasswordNew);

           this.hostRepository.save(host);
        }
        else
            throw new InputMismatchException("Passwords do not match.");
    }

    @Override
    public void updateHostEmail(String oldEmail, String newEmail) {
        Host repoHost = this.hostRepository.getFirstByEmail(oldEmail);

        repoHost.setEmail(newEmail);

        this.hostRepository.save(repoHost);
    }

    @Override
    public void deleteHost(long id) {
        this.hostRepository.deleteById(id);
    }

    @Override
    public void deleteHost(Host host) {
        Host repoHost = this.hostRepository.getFirstByEmail(host.getEmail());

        this.hostRepository.delete(repoHost);
    }



}
