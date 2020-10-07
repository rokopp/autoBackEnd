package com.example.auto24backend.dto;

import com.example.auto24backend.database.CarMark;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class DetailedAdvertisementDto {

    private Long id;

    private String price;

    private CarMark carMark;

    private String description;

    private List<PictureDto> pictureList;

    private UserDto user;

}
