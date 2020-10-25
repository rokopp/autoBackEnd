package com.example.auto24backend.controller;

import com.example.auto24backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public String registerAccount(@RequestBody Map<String, String> register) {
        return accountService.saveAccount(register);
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> body) {
        return accountService.login(body);
    }
}
