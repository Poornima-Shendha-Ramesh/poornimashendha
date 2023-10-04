package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.models.CustomerReqDTO;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Operation(summary = "To save Customer details")
    @PostMapping(value="/details")
    public ResponseEntity<String> saveCustomerDetails(@RequestBody List<CustomerReqDTO> customerList){
        customerService.saveCustomers(customerList);
        return new ResponseEntity<>("Successfully saved",HttpStatus.OK);
    }

}