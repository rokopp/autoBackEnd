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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileTypeDetector;
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
        Path picturesPath = null;
        try {

            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toRealPath().toString() + "/src/main/pictures";
            picturesPath = Paths.get(s);

            File directory = new File(picturesPath.toString());
            if (!directory.exists()) {
                Files.createDirectories(picturesPath);
            }


        } catch (IOException e) {

            System.err.println("Failed to create directory!" + e.getMessage());

        }

        String fileType = multipartFile.getContentType();
        if (!fileType.endsWith("jpg") && !fileType.endsWith("png")) {
            return;
        }
        String fileName = advertisement.getId() + "_" + multipartFile.getOriginalFilename();
        try {
            assert picturesPath != null;
            File file = new File(picturesPath.toString() + "/" + fileName);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Picture picture = Picture.builder()
                .filePath(picturesPath.toString() + "/")
                .fileName(fileName)
                .advertisement(advertisement)
                .build();
        pictureRepository.save(picture);
    }
}
