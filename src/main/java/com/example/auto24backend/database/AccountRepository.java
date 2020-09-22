package com.example.auto24backend.database;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByUserNameAndPassword(String userName, String password);
}
