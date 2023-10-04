package org.example.service;

import org.example.entities.Customer;
import org.example.models.CustomerReqDTO;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void saveCustomers(List<CustomerReqDTO> customerList) {
        List<Customer> customers = new ArrayList<>();
for(CustomerReqDTO customerReq : customerList){
    Customer customer = new Customer();
    BeanUtils.copyProperties(customerReq,customer);
    customers.add(customer);
}
        customerRepository.saveAll(customers);
    }
}
