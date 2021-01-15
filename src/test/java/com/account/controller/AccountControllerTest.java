package com.account.controller;


import com.account.dao.AccountRepository;
import com.account.dao.TransactionRepository;
import com.account.exception.Constants;
import com.account.exception.ServiceException;
import com.account.model.Account;
import com.account.model.Transaction;
import com.account.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.springframework.hateoas.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Test class for account service.
 */
public class AccountControllerTest {

    AccountService AccountService = Mockito.mock(AccountService.class);

    AccountController accountController;

    @BeforeEach
    public void setUp() {
        accountController = new AccountController(AccountService);
    }
}
