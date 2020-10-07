package com.example.auto24backend.repository;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.Picture;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PictureRepository extends PagingAndSortingRepository<Picture, Long> {

    List<Picture> findByAdvertisement(Advertisement advertisement);
}
