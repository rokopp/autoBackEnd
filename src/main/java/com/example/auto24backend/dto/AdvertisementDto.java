package com.example.auto24backend.dto;

import com.example.auto24backend.database.CarMark;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @Builder
public class AdvertisementDto {

    private Long id;

    private String price;

    private String serialNr;

    private CarMark carMark;

    private String description;

    private List<PictureDto> pictureList;

    private AccountDto account;

}
