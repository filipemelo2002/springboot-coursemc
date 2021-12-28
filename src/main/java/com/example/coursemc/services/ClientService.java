package com.example.coursemc.services;

import com.example.coursemc.domain.Client;
import com.example.coursemc.repositories.ClientRepository;
import com.example.coursemc.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {


    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client search (Integer id) {
        Optional<Client> clients = repository.findById(id);
        return clients.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found ID: "+id+", type: "+ Client.class.getName()
        ));
    }


}
