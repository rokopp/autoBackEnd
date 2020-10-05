package com.example.auto24backend.repository;

import com.example.auto24backend.database.CarMark;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMarkRepository extends PagingAndSortingRepository<CarMark, Long> {

    List<CarMark> findAllByOrderByCarMark();
}
