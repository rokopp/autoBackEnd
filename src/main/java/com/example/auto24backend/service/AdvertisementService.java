package com.example.auto24backend.service;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.database.Picture;
import com.example.auto24backend.dto.AdvertisementDto;
import com.example.auto24backend.exceptions.InvalidAdvertisementException;
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
        List<Advertisement> advertisements =  advertisementRepository.findAll();
        return getAdvertisementDtos(advertisements);
    }

    public String save(Advertisement advertisement, String userName, MultipartFile file) {
        Account account = accountService.findUserByUserName(userName);
        System.out.println("account shit " + account);
        if (account == null) {
            throw new InvalidAdvertisementException("Wrong acc");
        }
        advertisement.setAccount(account);
        Advertisement ad = advertisementRepository.saveAndFlush(advertisement);

        if (file != null) {
            pictureService.savePicture(file, ad);
        }
        return "Advertisement successfully saved";
    }

    public List<AdvertisementDto> findByCarMark(CarMark carMark) {
        List<Advertisement> advertisements =  advertisementRepository.findAllByCarMark(carMark);
        return getAdvertisementDtos(advertisements);
    }

    public List<AdvertisementDto> findByPrice(Integer start, Integer stop) {
        if (start.equals(stop)) {
            throw new InvalidAdvertisementException("Price cant be the same.");
        }
        List<Advertisement> advertisements =  advertisementRepository.findAllByPriceBetween(start, stop);
        return getAdvertisementDtos(advertisements);
    }

    private List<AdvertisementDto> getAdvertisementDtos(List<Advertisement> advertisements) {
        List<AdvertisementDto> advertisementDtoList = new ArrayList<>();
        for (Advertisement advertisement : advertisements) {
            advertisementDtoList.add(convert(advertisement));
        }
        return advertisementDtoList;
    }

    private AdvertisementDto convert(Advertisement advertisement) {
        return AdvertisementDto.builder()
                .id(advertisement.getId())
                .carMark(advertisement.getCarMark())
                .description(advertisement.getDescription())
                .serialNr(advertisement.getCarSerialNr())
                .price(advertisement.getPrice())
                .pictureList(pictureService.getPictures(advertisement))
                .account(accountService.convert(advertisement.getAccount()))
                .build();
    }
}
