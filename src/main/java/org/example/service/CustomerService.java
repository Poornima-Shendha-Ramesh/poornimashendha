package org.example.service;

import org.example.models.CustomerReqDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void saveCustomers(List<CustomerReqDTO> customer);
}
