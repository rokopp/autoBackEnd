package com.example.auto24backend.service;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Role;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.repository.AccountRepository;
import com.example.auto24backend.repository.RoleRepository;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Account findUserByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    public String login(String username, String password) {
        String storedPass;
        try {
            storedPass = accountRepository.findByUserName(username).getPassword();
        } catch (NullPointerException e) {
            return StringUtils.EMPTY;
        }
        if (bCryptPasswordEncoder.matches(password, storedPass)) {
            Optional<Account> account = accountRepository.login(username);
            if (account.isPresent()) {
                String token = UUID.randomUUID().toString();
                Account acc = account.get();
                acc.setToken(token);
                accountRepository.save(acc);
                ArrayList<String> listOfRoles = new ArrayList<String>();

                for (Role role:acc.getRoleSet()) {
                    listOfRoles.add(role.getName());
                }

                JSONObject response = new JSONObject();
                response.put("token", token);
                response.put("role", listOfRoles);

                return response.toString();
            }
        }
        return StringUtils.EMPTY;
    }

    public Optional<User> accountFinder(Optional<Account> account) {
        if(account.isPresent()){
            Account account1 = account.get();
            User user = null;
            ArrayList<String> listOfRoles = new ArrayList<String>();
            for (Role role:account1.getRoleSet()) {
                listOfRoles.add(role.getName());
            }
            if (listOfRoles.contains("ADMIN")) {
                user= new User(account1.getUserName(), account1.getPassword(), true, true, true, true,
                        AuthorityUtils.createAuthorityList("USER", "ADMIN"));
            } else {
                user= new User(account1.getUserName(), account1.getPassword(), true, true, true, true,
                        AuthorityUtils.createAuthorityList("USER"));
            }
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    public Optional<User> findByToken(String token) {
        Optional<Account> account = accountRepository.findByToken(token);
        return accountFinder(account);
    }
    public Account findById(Long id) {
        Optional<Account> account= accountRepository.findById(id);
        return account.orElse(null);
    }

    public AccountDto saveAccount(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        Role userRole = roleRepository.findByName("USER");

        String token = UUID.randomUUID().toString();
        account.setToken(token);

        account.setRoleSet(new HashSet<Role>(Collections.singletonList(userRole)));
        return convert(accountRepository.save(account));
    }

    public AccountDto saveAdmin(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        Role userRole = roleRepository.findByName("USER");
        Role adminRole = roleRepository.findByName("ADMIN");

        String token = UUID.randomUUID().toString();
        account.setToken(token);

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
