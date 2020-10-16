package com.example.auto24backend.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @Builder @AllArgsConstructor
public class AccountDto {

    private Long id;

    private String email;

    private String phoneNumber;

}
