package com.example.auto24backend.database;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends PagingAndSortingRepository<Marks, Long> {

    List<Marks> findAllByOrderByCarMark();
}
