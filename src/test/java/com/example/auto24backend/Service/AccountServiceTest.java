package com.example.auto24backend.Service;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.dto.AccountDto;
import com.example.auto24backend.repository.AccountRepository;
import com.example.auto24backend.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountServiceTest {

    @Mock
    private AccountRepository mockUserRepository;

    @Autowired
    private AccountService accountServiceUnderTest;

    private Account account;

    @Before
    public void setUp() {
        initMocks(this);
        account = Account.builder()
                .id(5L)
                .userName("Robin")
                .password("123")
                .email("test@test.com")
                .phoneNumber("55555")
                .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(account);
        Mockito.when(mockUserRepository.findByUserName(anyString()))
                .thenReturn(account);
    }

    @Test
    public void testFindUserByEmail() {
        final String userName = "Robin";

        final Account result = accountServiceUnderTest.findUserByUserName(userName);

        assertEquals(userName, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        final String email = "test@test.com";

        AccountDto result = accountServiceUnderTest.saveAccount(Account.builder().build());

        assertEquals(email, result.getEmail());
    }
}