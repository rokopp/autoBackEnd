package com.example.auto24backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @Builder
public class PictureDto {

    private Long id;

    private byte[] pictureFile;

}
