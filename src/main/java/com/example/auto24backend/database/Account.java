package com.example.auto24backend.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String userName;

    private String password;

    @Column(unique=true)
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "account")
    private List<Advertisement> advertisements;

    public Account(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
