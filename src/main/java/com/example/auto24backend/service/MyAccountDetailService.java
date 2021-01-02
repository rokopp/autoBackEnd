package com.example.auto24backend.service;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Role;
import com.example.auto24backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyAccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(userName);
        if(account == null) {
            throw new UsernameNotFoundException("User name not found");
        }
        List<GrantedAuthority> authorities = getUserAuthority(account.getRoleSet());
        return buildUserForAuthentication(account, authorities);

    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Account account, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(account.getUserName(), account.getPassword(),
                true, true, true, true, authorities);
    }

}
