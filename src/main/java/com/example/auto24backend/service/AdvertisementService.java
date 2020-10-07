package com.example.auto24backend.service;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.dto.DetailedAdvertisementDto;
import com.example.auto24backend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private PictureService pictureService;

    public List<AdvertisementDto> findAll() {
        List<AdvertisementDto> advertisementDtoList = new ArrayList<>();
        List<Advertisement> advertisements =  advertisementRepository.findAll();
        for(Advertisement advertisement : advertisements) {
            advertisementDtoList.add(convert(advertisement));
        }
        return advertisementDtoList;
    }

    public DetailedAdvertisementDto findById(Long id) {
        return null;
    }

    private AdvertisementDto convert(Advertisement advertisement) {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setCarMark(advertisement.getCarMark());
        advertisementDto.setPrice(advertisement.getPrice());
        advertisementDto.setPicture(pictureService.getPictures(advertisement).get(0));
        return advertisementDto;
    }

}
