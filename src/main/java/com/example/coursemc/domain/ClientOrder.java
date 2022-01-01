package com.example.coursemc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ClientOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date timestamp;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public ClientOrder() {

    }

    public ClientOrder(Integer id, Date timestamp, Client client, Address deliveryAddress) {
        this.id = id;
        this.timestamp = timestamp;
        this.client = client;
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOrder clientOrder = (ClientOrder) o;
        return id.equals(clientOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
