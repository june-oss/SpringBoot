package com.june.springbootjdbc.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRespositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getUserName());
        }

        Account account = new Account();
        account.setUsername("hyeon");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        Assertions.assertTrue(existingAccount.isPresent());

        Optional<Account> nonExistingAccount = accountRepository.findByUsername("hyeonjung");
        Assertions.assertFalse(nonExistingAccount.isPresent());
    }
}
