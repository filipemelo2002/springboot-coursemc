package com.example.coursemc.resources;

import com.example.coursemc.domain.ClientOrder;
import com.example.coursemc.services.ClientOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class ClientOrderResource {

    private final ClientOrderService service;

    public ClientOrderResource(ClientOrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}",  method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable("id") Integer id) {
        ClientOrder obj = service.search(id);

        return ResponseEntity.ok().body(obj);
    }


}
