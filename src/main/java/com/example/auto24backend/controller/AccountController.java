package com.example.auto24backend.controller;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.service.AccountService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/register")
    public AccountDto register(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PostMapping("/registerAdmin")
    public AccountDto registerAdmin(@RequestBody Account account) {
        return accountService.saveAdmin(account);
    }

}
