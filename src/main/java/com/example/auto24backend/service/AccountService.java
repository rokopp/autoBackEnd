package com.example.auto24backend.service;


import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.Role;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.repository.AccountRepository;
import com.example.auto24backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Account findUserByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account findUserByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    public AccountDto saveUser(Account account) {
        Role userRole = roleRepository.findByRole("ROLE_USER");
        account.setRoleSet(new HashSet<Role>(Collections.singletonList(userRole)));
        return convert(accountRepository.save(account));
    }

    public AccountDto saveAdmin(Account account) {
        Role userRole = roleRepository.findByRole("ROLE_USER");
        Role adminRole = roleRepository.findByRole("ROLE_ADMIN");
        account.setRoleSet(new HashSet<Role>(Arrays.asList(userRole, adminRole)));
        return convert(accountRepository.save(account));
    }

    public AccountDto convert(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .phoneNumber(account.getPhoneNumber())
                .email(account.getEmail())
                .build();
    }
}
