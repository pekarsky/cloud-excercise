package com.grapeup.pekarsky.orderservice.web;

import com.grapeup.pekarsky.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private Map<Long, List<Order>> orders = Map.of(
            1L, Arrays.asList(new Order(1L, 100L), new Order(5L, 500L) ),
            2L, Arrays.asList(new Order(2L, 200L), new Order(6L, 600L) )
    );

    @GetMapping
    public List<Order> getOrdersByCustomerId(@PathParam("customerId") Long customerId){
        return orders.get(customerId);
    }

}
