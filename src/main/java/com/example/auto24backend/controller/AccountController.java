package com.example.auto24backend.controller;

import com.example.auto24backend.database.Users;
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
        System.out.println(body.get("email"));
        String userName = body.get("userName");
        String password = body.get("password");
        String email = body.get("email");
        String phoneNumber = body.get("phoneNumber");
        Users users = new Users(userName, password, email, phoneNumber);

        return accountService.saveAccount(users);
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> body) {
        String userName = body.get("userName");
        String password = body.get("password");
        return accountService.login(userName, password);
    }
}
