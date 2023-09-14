package com.springdatajpa20.Controller;


import com.springdatajpa20.Entity.Orders;
import com.springdatajpa20.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/saveOrders")
    public ResponseEntity<Orders> saveOrders(@RequestBody Orders orders){
        return ordersService.saveOrders(orders);
    }
}
