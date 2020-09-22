package com.example.auto24backend.database;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {

    List<Users> findByUserNameAndPassword(String userName, String password);
}
