package com.example.auto24backend.service;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<AdvertisementDto> findAll() {
        List<AdvertisementDto> advertisementDtoList = new ArrayList<>();
        List<Advertisement> advertisements =  advertisementRepository.findAll();
        for(Advertisement advertisement : advertisements) {
            advertisementDtoList.add(convert(advertisement));
        }
        return advertisementDtoList;
    }

    private AdvertisementDto convert(Advertisement advertisement) {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setCarMark(advertisement.getCarMark());
        advertisementDto.setPrice(advertisement.getPrice());
        //Add later picture so dto
        //TODO
        return advertisementDto;
    }
}
