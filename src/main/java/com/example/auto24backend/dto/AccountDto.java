package com.example.auto24backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @Builder
public class AccountDto {

    private Long id;

    private String email;

    private String phoneNumber;

}
