package com.pos.demo.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.demo.Entities.client;
import com.pos.demo.Repositories.ClientRepository;
import com.pos.demo.models.RegisterClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

/*................. register client details..............*/

    public Map<String,Object> register(RegisterClientRequest clientrequest){
        Map<String,Object> map= new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        client obj= new client();
        obj.setEmail(clientrequest.getEmail());
        obj.setCreatedOn(new Date(System.currentTimeMillis()));
        obj.setFirstname(clientrequest.getFirstname());
        obj.setLastname(clientrequest.getLastname());
        obj.setPassword(clientrequest.getPassword());
        obj.setPhone(clientrequest.getPhone());
        clientRepository.save(obj);
        map.put("message","registration sucessful");
        return  map;
    }




}
