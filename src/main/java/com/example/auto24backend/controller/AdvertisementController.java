package com.example.auto24backend.controller;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("/api/ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.findAll();
    }

    @GetMapping("{id}")
    public AdvertisementDto getAdvertisement(@PathVariable Long id) {
        return advertisementService.findById(id);
    }

    @PostMapping
    public String saveAdvertisement(@RequestPart("userName") String userName,
                                    @RequestPart("file") MultipartFile file,
                                    @RequestPart("ad") Advertisement advertisement) {
        return advertisementService.save(advertisement, userName, file);
    }
}
