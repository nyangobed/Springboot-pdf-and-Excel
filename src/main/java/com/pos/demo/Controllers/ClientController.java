package com.pos.demo.Controllers;

import com.pos.demo.Services.ClientService;
import com.pos.demo.models.RegisterClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    /*................. register client endpoint.............*/
    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterClientRequest clientRequest){
        Map<String, Object> response= new HashMap<>();
        response =clientService.register(clientRequest);
        return  new ResponseEntity(response, HttpStatus.OK);

    }
}
