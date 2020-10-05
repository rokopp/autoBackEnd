package com.example.auto24backend.service;


import com.example.auto24backend.database.Account;
import com.example.auto24backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public String saveAccount(Account account) {

        if(account.getEmail() == null) {
            return "wrong Email";
        } else if (account.getPassword() == null){
            return "wrong Password";
        } else if (account.getUserName() == null){
            return "wrong username";
        } else if (account.getPhoneNumber() == null){
            return "wrong phone number";
        }

        try
        {
            accountRepository.save(account);
        }
        catch (Exception e)
        {
            return "An account already exists with this name and/or e-mail. Please try again.";
        }
        return "success";
    }
    
    public String login(String userName, String password) {
        List<Account> accountList = accountRepository.findByUserNameAndPassword(userName, password);
        if (accountList.size() == 1) {
            return "success";
        } else {
            return "No account found";
        }
    } 

}
