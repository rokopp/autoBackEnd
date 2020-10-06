package com.example.auto24backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private String phoneNumber;

}
