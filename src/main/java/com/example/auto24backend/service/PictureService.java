package com.example.auto24backend.service;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.Picture;
import com.example.auto24backend.dto.PictureDto;
import com.example.auto24backend.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<PictureDto> getPictures(Advertisement advertisement) throws IOException {
        List<PictureDto> pictureDtoList = new ArrayList<>();
        List<Picture> pictures = pictureRepository.findByAdvertisement(advertisement);
        for(Picture picture: pictures) {
            pictureDtoList.add(convert(picture));
        }
        return pictureDtoList;
    }

    private PictureDto convert(Picture picture) throws IOException {
        String filePath = picture.getFilePath() + picture.getFileName();
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        PictureDto pictureDto = new PictureDto();
        pictureDto.setId(picture.getId());
        pictureDto.setPictureFile(bytes);
        return pictureDto;
    }

    public String savePicture(MultipartFile multipartFile){
        //TODO
        return null;
    }
}
