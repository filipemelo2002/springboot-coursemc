package com.example.coursemc.services;

import com.example.coursemc.domain.ClientOrder;
import com.example.coursemc.repositories.ClientOrderRepository;
import com.example.coursemc.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientOrderService {


    private final ClientOrderRepository repository;

    public ClientOrderService(ClientOrderRepository repository) {
        this.repository = repository;
    }

    public ClientOrder search (Integer id) {
        Optional<ClientOrder> clients = repository.findById(id);
        return clients.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found ID: "+id+", type: "+ ClientOrder.class.getName()
        ));
    }


}
