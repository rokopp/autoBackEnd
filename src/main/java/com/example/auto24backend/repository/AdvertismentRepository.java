package com.example.auto24backend.repository;

import com.example.auto24backend.database.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertismentRepository extends JpaRepository<Advertisement, Long> {
}
