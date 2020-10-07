package com.example.auto24backend.dto;

import com.example.auto24backend.database.CarMark;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AdvertisementDto {

    private Long id;

    private String price;

    private CarMark carMark;

    private PictureDto picture;

}
