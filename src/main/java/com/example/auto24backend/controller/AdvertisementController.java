package com.example.auto24backend.controller;

import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.dto.DetailedAdvertisementDto;
import com.example.auto24backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/api/ads")
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.findAll();
    }

    @GetMapping("{id}")
    public DetailedAdvertisementDto getAdvertisement(@PathVariable Long id) {
        return advertisementService.findById(id);
    }

}
