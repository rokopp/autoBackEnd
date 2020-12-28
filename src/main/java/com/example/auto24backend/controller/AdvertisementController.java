package com.example.auto24backend.controller;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RequestMapping({"api/ads"})
@RestController
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.findAll();
    }

    @PostMapping
    public String saveAdvertisement(@RequestParam(value = "userName") String userName,
                                    @RequestParam(value = "file", required = false) MultipartFile file,
                                    @RequestParam(value =  "ad") Advertisement advertisement) {
        return advertisementService.save(advertisement, userName, file);
    }

    @GetMapping("/search")
    public List<AdvertisementDto> findByPrice(@RequestParam("start") Integer start,
                                              @RequestParam("stop") Integer stop) {
        return advertisementService.findByPrice(start, stop);
    }

    @PostMapping("/search")
    public List<AdvertisementDto> findByCarMark(@RequestBody CarMark carMark) {
        return advertisementService.findByCarMark(carMark);
    }
}
