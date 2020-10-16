package com.example.auto24backend.service;


import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public String saveAccount(Map<String, String> register) {
        if(register.get("email") == null) {
            return "wrong Email";
        } else if (register.get("password") == null){
            return "wrong Password";
        } else if (register.get("userName") == null){
            return "wrong username";
        } else if (register.get("phoneNumber") == null){
            return "wrong phone number";
        }
        Account account = Account.builder()
                .email(register.get("email"))
                .phoneNumber(register.get("phoneNumber"))
                .password(register.get("password"))
                .userName(register.get("userName"))
                .build();
        try {
            accountRepository.save(account);
        } catch (Exception e) {
            return "An account already exists with this name and/or e-mail. Please try again.";
        }
        return "success";
    }
    
    public String login(Map<String, String> body) {
        String userName = body.get("userName");
        String password = body.get("password");
        List<Account> accountList = accountRepository.findByUserNameAndPassword(userName, password);
        if (accountList.size() == 1) {
            return "success";
        } else {
            return "No account found";
        }
    }

    public List<Account> findByName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    public AccountDto convertAccount(Advertisement advertisement) {
        return AccountDto.builder()
                .id(advertisement.getAccount().getId())
                .email(advertisement.getAccount().getEmail())
                .phoneNumber(advertisement.getAccount().getPhoneNumber())
                .build();
    }

}
