package com.june.springbootsecurity;

import com.june.springbootsecurity.account.Account;
import com.june.springbootsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account hyeonjung = accountService.createAccount("hyeonjung", "1234");
        System.out.println(hyeonjung.getUsername() + " paassword: " + hyeonjung.getPassword());
    }
}
