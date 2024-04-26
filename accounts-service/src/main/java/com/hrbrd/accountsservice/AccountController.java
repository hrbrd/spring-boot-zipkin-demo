package com.hrbrd.accountsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AccountController {

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") String id) {
        return new Account(UUID.randomUUID().toString(), Integer.parseInt(id) * 987 + 5);
    }

}