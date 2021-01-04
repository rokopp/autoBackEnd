package com.example.auto24backend.repository;

import com.example.auto24backend.database.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Account findByUserName(String userName);
    @Query(value = "SELECT u FROM Account u where u.userName = ?1")
    Optional<Account> login(String username);
    Optional<Account> findByToken(String token);
}
