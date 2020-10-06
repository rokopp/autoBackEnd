package com.example.auto24backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class PictureDto {

    private Long id;

    private byte[] pictureFile;

}
