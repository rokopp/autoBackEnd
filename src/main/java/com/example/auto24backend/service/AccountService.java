package com.example.auto24backend.service;


import com.example.auto24backend.database.Users;
import com.example.auto24backend.database.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private UsersRepository usersRepository;

    public String saveAccount(Users users) {

        if(users.getEmail() == null ) {
            return "wrong Email";
        } else if (users.getPassword() == null){
            return "wrong Password";
        } else if (users.getUserName() == null){
            return "wrong username";
        } else if (users.getPhoneNumber() == null){
            return "wrong phone number";
        }

        try
        {
            usersRepository.save(users);
        }
        catch (Exception e)
        {
            return "An account already exists with this name and/or e-mail. Please try again.";
        }
        return "success";
    }
    
    public String login(String userName, String password) {
        List<Users> usersList = usersRepository.findByUserNameAndPassword(userName, password);
        if (usersList.size() == 1) {
            return "success";
        } else {
            return "No account found";
        }
    } 

}
