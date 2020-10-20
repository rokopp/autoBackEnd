package com.example.auto24backend.repository;

import com.example.auto24backend.database.Account;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository repository;

    @Test
    public void testAccountRepositoryFindByNameAndPassword() throws Exception {
        Account account = new Account();
        account.setUserName("test_name");
        account.setPassword("test_password");

        this.entityManager.persist(account);
        List<Account> accounts = this.repository.findByUserNameAndPassword("test_name", "test_password");
        assert (accounts.size() == 1);
        assert (accounts.get(0).getUserName().equals("test_name"));
        assert (accounts.get(0).getPassword().equals("test_password"));
    }
}
