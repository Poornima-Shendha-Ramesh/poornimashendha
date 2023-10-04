package org.example.service;

import org.example.Exception.ProductsException;
import org.example.entities.Orders;
import org.example.models.OrdersReqDTO;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService{
    @Autowired
   private OrderRepository orderRepository;

    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveOrders(List<OrdersReqDTO> ordersList) throws ProductsException {
        try{


        List<Orders> orderDetails = new ArrayList<>();
        for(OrdersReqDTO ordersReq : ordersList){
            Orders orders = new Orders();
            var customer = customerRepository.findById(Long.valueOf(ordersReq.getCustomerId())).get();
            var product = productRepository.findById(Long.valueOf(ordersReq.getProductId())).get();
            orders.setCustomer(customer);
            orders.setProducts(product);


            orderDetails.add(orders);
        }
        orderRepository.saveAll(orderDetails);
        }catch (Exception e){
            throw new ProductsException(e.getMessage());
        }

    }
}
