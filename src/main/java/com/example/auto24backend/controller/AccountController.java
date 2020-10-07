package com.example.auto24backend.controller;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/api/registerAccount", method = RequestMethod.POST)
    public String registerAccount(@RequestBody Map<String, String> body) {
        String userName = body.get("userName");
        String password = body.get("password");
        String email = body.get("email");
        String phoneNumber = body.get("phoneNumber");
        Account account = new Account(userName, password, email, phoneNumber);
        return accountService.saveAccount(account);
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> body) {
        String userName = body.get("userName");
        String password = body.get("password");
        return accountService.login(userName, password);
    }
}
