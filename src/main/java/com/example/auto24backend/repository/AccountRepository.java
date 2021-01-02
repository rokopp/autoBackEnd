package com.example.auto24backend.repository;

import com.example.auto24backend.database.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Account findByUserName(String userName);
    Account findByEmail(String email);
}
