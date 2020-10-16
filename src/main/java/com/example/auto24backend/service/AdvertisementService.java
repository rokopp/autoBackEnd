package com.example.auto24backend.service;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private AccountService accountService;

    public List<AdvertisementDto> findAll() {
        List<AdvertisementDto> advertisementDtoList = new ArrayList<>();
        List<Advertisement> advertisements =  advertisementRepository.findAll();
        for(Advertisement advertisement : advertisements) {
            advertisementDtoList.add(convert(advertisement));
        }
        return advertisementDtoList;
    }

    public String save(Advertisement advertisement, String userName, MultipartFile multipartFile) {
        List<Account> accounts = accountService.findByName(userName);
        if (!(accounts.size() == 1)) {
            return "Wrong account";
        }
        advertisement.setAccount(accounts.get(0));
        advertisementRepository.save(advertisement);
        pictureService.savePicture(multipartFile, advertisement);
        return "Advertisement successfully saved";
    }

    private AdvertisementDto convert(Advertisement advertisement) {
        return AdvertisementDto.builder()
                .id(advertisement.getId())
                .carMark(advertisement.getCarMark())
                .description(advertisement.getDescription())
                .serialNr(advertisement.getCarSerialNr())
                .price(advertisement.getPrice())
                .pictureList(pictureService.getPictures(advertisement))
                .account(accountService.convertAccount(advertisement))
                .build();
    }
}
