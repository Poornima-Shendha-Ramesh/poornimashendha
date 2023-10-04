package org.example.service;

import org.example.Exception.ProductsException;
import org.example.models.OrdersReqDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void saveOrders(List<OrdersReqDTO> ordersList) throws ProductsException;
}
