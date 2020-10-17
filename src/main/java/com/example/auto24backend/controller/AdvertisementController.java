package com.example.auto24backend.controller;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/api/ads")
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.findAll();
    }

    @PostMapping("/api/ads")
    public String saveAdvertisement(@RequestPart("userName") String userName,
                                    @RequestPart("file") MultipartFile file,
                                    @RequestPart("ad") Advertisement advertisement) {
        return advertisementService.save(advertisement, userName, file);
    }

    @GetMapping("/api/ads/search")
    public List<AdvertisementDto> findByPrice(@PathVariable("start") Integer start,
                                              @PathVariable("stop") Integer stop) {
        return advertisementService.findByPrice(start, stop);
    }

    @PostMapping("/api/ads/search")
    public List<AdvertisementDto> findByCarMark(@RequestBody CarMark carMark) {
        return advertisementService.findByCarMark(carMark);
    }
}
