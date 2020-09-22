package com.example.auto24backend.service;


import com.example.auto24backend.controller.AccountController;
import com.example.auto24backend.database.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountController accountController;

    public String saveAccount(Account account) {
        //TODO
        return "";
    }

}
