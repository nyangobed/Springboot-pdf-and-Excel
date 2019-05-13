package com.pos.demo.Repositories;

import com.pos.demo.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<customer, Long>{

}
