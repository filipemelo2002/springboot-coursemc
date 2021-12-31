package com.example.coursemc.repositories;

import com.example.coursemc.domain.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Integer> {

}
