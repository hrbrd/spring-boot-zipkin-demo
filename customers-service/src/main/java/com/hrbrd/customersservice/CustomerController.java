package com.hrbrd.customersservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") String id) {
        User user = restTemplate.getForObject("http://localhost:8082/" + id, User.class);
        Account account = restTemplate.getForObject("http://localhost:8083/" + id, Account.class);
        return mapCustomer(user, account);
    }

    private Customer mapCustomer(User user, Account account) {
        Customer customer = new Customer();
        customer.setId(user.getId());
        customer.setFirstName(user.getFirstName());
        customer.setLastName(user.getLastName());
        customer.setAge(user.getAge());
        customer.setEmail(user.getEmail());
        customer.setAccountId(account.getId());
        customer.setBalance(account.getBalance());
        return customer;
    }

}