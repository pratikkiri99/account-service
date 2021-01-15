package com.account.service;

import com.account.model.Account;
import com.account.model.Transaction;
import org.springframework.hateoas.Resources;

import java.util.List;

public interface AccountService {
    List<Account> getAccountsForUser(String userId);
    Resources<Transaction> getTransactionsForAccount(String accountNum);
}

