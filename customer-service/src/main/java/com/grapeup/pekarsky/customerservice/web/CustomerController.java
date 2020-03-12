package com.grapeup.pekarsky.customerservice.web;

import com.grapeup.pekarsky.model.Customer;
import com.grapeup.pekarsky.model.Order;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@EnableEurekaClient
public class CustomerController {

    @Autowired
    private EurekaClient client;

    @Autowired
    private RestTemplateBuilder builder;


    private Map<Long, Customer> customers = Map.of(
            1L, new Customer(1L, "Marcin", "Dorywalski", null),
            2L, new Customer(2L, "Sergii", "Pekarskyi", null)
    );

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Customer customer = customers.get(id);
        customer.setOrders(getOrders(id));
        return customer;
    }

    private List<Order> getOrders(Long id) {
        RestTemplate restTemplate = builder.build();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("order-service", false);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(instanceInfo.getHomePageUrl() + "orders")
                .queryParam("customerId", id);
        ResponseEntity<List> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,null, List.class);
        return (List<Order>) response.getBody();
    }


}
