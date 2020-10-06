package com.example.auto24backend.service;

import com.example.auto24backend.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;


}
