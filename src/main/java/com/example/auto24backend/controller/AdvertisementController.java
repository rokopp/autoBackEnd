package com.example.auto24backend.controller;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
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
    public String saveAdvertisement(@RequestPart("ad") Advertisement advertisement,
                                    @RequestPart("picture") MultipartFile file,
                                    Principal principal) {
        return advertisementService.save(advertisement, principal.getName(), file);
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
