package com.example.auto24backend.controller;

import com.example.auto24backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //TODO

}
