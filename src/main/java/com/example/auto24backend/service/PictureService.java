package com.example.auto24backend.service;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.Picture;
import com.example.auto24backend.dto.PictureDto;
import com.example.auto24backend.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<PictureDto> getPictures(Advertisement advertisement) {
        List<PictureDto> pictureDtoList = new ArrayList<>();
        List<Picture> pictures = pictureRepository.findByAdvertisement(advertisement);
        for(Picture picture: pictures) {
            pictureDtoList.add(convert(picture));
        }
        return pictureDtoList;
    }

    private PictureDto convert(Picture picture) {
        String filePath = picture.getFilePath() + picture.getFileName();
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            return null;
        }
        PictureDto pictureDto = new PictureDto();
        pictureDto.setId(picture.getId());
        pictureDto.setPictureFile(bytes);
        return pictureDto;
    }

    public void savePicture(MultipartFile multipartFile, Advertisement advertisement) {
        if (!multipartFile.getOriginalFilename().endsWith(".jpg")) {
            return;
        } else if(!multipartFile.getOriginalFilename().endsWith(".png")) {
            return;
        }
        try {
            File file = new File("/pictures/" + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Picture picture = Picture.builder()
                .filePath("/pictures/")
                .fileName(multipartFile.getOriginalFilename())
                .advertisement(advertisement)
                .build();
        pictureRepository.save(picture);
    }
}
