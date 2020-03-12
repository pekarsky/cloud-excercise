package com.grapeup.pekarsky.orderservice.web;

import com.grapeup.pekarsky.model.Order;
import com.grapeup.pekarsky.orderservice.jpa.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrdersByCustomerId(@PathParam("customerId") Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

}
