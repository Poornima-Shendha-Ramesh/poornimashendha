package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.Exception.ProductsException;
import org.example.models.OrdersReqDTO;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value="/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Operation(summary="To save order details")
    @PostMapping(value="/details")
    public ResponseEntity<String> saveCustomerDetails(@RequestBody List<OrdersReqDTO> ordersList) throws ProductsException {
        orderService.saveOrders(ordersList);
        return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }
}
