package com.example.auto24backend.controller;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/api/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        return accountService.login(username, password);
    }

    @PostMapping("/api/logout")
    public String logout(@RequestPart(value = "username") String username) {
        return username;
    }

    @PostMapping("/api/register")
    public AccountDto register(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PostMapping("/api/admin/registerAdmin")
    public AccountDto registerAdmin(@RequestBody Account account) {
        return accountService.saveAdmin(account);
    }

}
