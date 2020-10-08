package com.example.auto24backend.service;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.dto.DetailedAdvertisementDto;
import com.example.auto24backend.dto.UserDto;
import com.example.auto24backend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Advertisement advertisement = advertisementRepository.findById(id).get();
        return convertDetailed(advertisement);
    }

    private AdvertisementDto convert(Advertisement advertisement) {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setCarMark(advertisement.getCarMark());
        advertisementDto.setPrice(advertisement.getPrice());
        advertisementDto.setPicture(pictureService.getPictures(advertisement).get(0));
        return advertisementDto;
    }

    private DetailedAdvertisementDto convertDetailed(Advertisement advertisement) {
        DetailedAdvertisementDto detailedAdvertisementDto = new DetailedAdvertisementDto();
        detailedAdvertisementDto.setId(advertisement.getId());
        detailedAdvertisementDto.setCarMark(advertisement.getCarMark());
        detailedAdvertisementDto.setDescription(advertisement.getDescription());
        detailedAdvertisementDto.setSerialNr(advertisement.getCarSerialNr());
        detailedAdvertisementDto.setPrice(advertisement.getPrice());
        detailedAdvertisementDto.setPictureList(pictureService.getPictures(advertisement));
        detailedAdvertisementDto.setUser(convertUser(advertisement));
        return detailedAdvertisementDto;
    }

    private UserDto convertUser(Advertisement advertisement) {
        UserDto userDto = new UserDto();
        userDto.setId(advertisement.getAccount().getId());
        userDto.setEmail(advertisement.getAccount().getEmail());
        userDto.setPhoneNumber(advertisement.getAccount().getPhoneNumber());
        return userDto;
    }

}
