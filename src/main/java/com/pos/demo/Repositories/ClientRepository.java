package com.pos.demo.Repositories;

import com.pos.demo.Entities.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepository extends CrudRepository<client, Long> {



}
