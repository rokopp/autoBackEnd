package com.example.auto24backend.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @Builder
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String userName;

    private String password;

    @Column(unique=true)
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<Advertisement> advertisements;

    public Account(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
