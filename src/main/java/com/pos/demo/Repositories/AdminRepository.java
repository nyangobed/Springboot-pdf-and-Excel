package com.pos.demo.Repositories;

import com.pos.demo.Entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
    Optional<Admin>findAdminByUsernameAndPassword(String username, String password);
}
