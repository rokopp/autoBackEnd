//package com.example.auto24backend.Service;
//
//import com.example.auto24backend.database.Account;
//import com.example.auto24backend.dto.AccountDto;
//import com.example.auto24backend.repository.AccountRepository;
//import com.example.auto24backend.service.AccountService;
//import org.junit.Test;
//import org.junit.jupiter.api.Disabled;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class AccountServiceTest {
//
//    @Autowired
//    private AccountRepository mockUserRepository;
//
//    @Autowired
//    private AccountService accountServiceUnderTest;
//
//    private Account account;
//
//
//
////    @Before
////    public void setUp() {
////        initMocks(this);
////        account = Account.builder()
////                .id(5L)
////                .userName("Robin")
////                .password("123")
////                .email("test@test.com")
////                .phoneNumber("55555")
////                .build();
////        System.out.println(account.toString());
////        Mockito.when(mockUserRepository.save(any()))
////                .thenReturn(account);
////        Mockito.when(mockUserRepository.findByUserName(anyString()))
////                .thenReturn(account);
////    }
//
//    @Test
//    public void testFindUserByName() {
//        final String userName = "Robin";
//        System.out.println("object" + account.toString());
//        final Account result = accountServiceUnderTest.findUserByUserName(userName);
//
//        assertEquals(userName, result.getEmail());
//    }
//
//    @Test
//    public void testSaveUser() {
//        final String email = "test@test.com";
//
//        AccountDto result = accountServiceUnderTest.saveAccount(Account.builder().build());
//
//        assertEquals(email, result.getEmail());
//    }
//}
