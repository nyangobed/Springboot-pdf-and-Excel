package com.pos.demo.Controllers;

import com.pos.demo.Services.CustomerService;
import com.pos.demo.models.RegisterClientRequest;
import com.pos.demo.models.RegisterCustomerRequest;
import com.pos.demo.models.RegisterTerminalRequest;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /*................. register customer endpoint.............*/

    @RequestMapping(value = "/registerCustomers", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterCustomerRequest customerRequest) {
        Map<String, Object> response = new HashMap<>();
        response = customerService.register(customerRequest);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
