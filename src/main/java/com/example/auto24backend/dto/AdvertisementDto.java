package com.example.auto24backend.dto;

import com.example.auto24backend.database.CarMark;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @Builder @AllArgsConstructor
public class AdvertisementDto {

    private Long id;

    private Integer price;

    private String serialNr;

    private CarMark carMark;

    private String description;

    private List<PictureDto> pictureList;

    private AccountDto account;

}
