package com.example.auto24backend.controller;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/api/registerAccount", method = RequestMethod.POST)
    public String registerAccount(WebRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Account account = new Account(userName, password, email, phoneNumber);

        return accountService.saveAccount(account);
    }
}
