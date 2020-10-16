package com.example.auto24backend.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @Builder @AllArgsConstructor
public class PictureDto {

    private Long id;

    private byte[] pictureFile;

}
