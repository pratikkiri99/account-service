package com.account.controller;


import com.account.dao.AccountRepository;
import com.account.dao.TransactionRepository;
import com.account.exception.Constants;
import com.account.exception.ServiceException;
import com.account.model.Account;
import com.account.model.Transaction;
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


    AccountRepository accountRepository = Mockito.mock(AccountRepository.class);

    TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);

    AccountController accountController;

    @BeforeEach
    public void setUp() {
        accountController = new AccountController(accountRepository, transactionRepository);
    }

    @Test
    public void testGetAccountsForUserWhenNull() {
        String userId = null;
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getAccountsForUser(userId));
        Assertions.assertEquals(Constants.INVALID_USER,e.getMessage());
    }

    @Test
    public void testGetAccountsForUserWhenEmpty() {
        String userId = "";
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getAccountsForUser(userId));
        Assertions.assertEquals(Constants.INVALID_USER,e.getMessage());
    }

    @Test
    public void testGetAccountsForUserWhenNoAccount() {
        String userId = "UserIdWithNoAccount";
        Mockito.when(accountRepository.findByUserId(userId)).thenReturn(null);
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getAccountsForUser(userId));
        Assertions.assertEquals(Constants.NO_ACCOUNT_FOR_USER,e.getMessage());
    }

    @Test
    public void testGetAccountsForUserWithValidData(){
        Account account1 = new Account();
        account1.setId("accountNum1");
        account1.setAccountName("accountName1");
        account1.setUserId("UserIdWithAccounts");

        Account account2 = new Account();
        account2.setId("accountNum2");
        account2.setAccountName("accountName2");
        account2.setUserId("UserIdWithAccounts");

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        String userId = "UserIdWithAccounts";
        Mockito.when(accountRepository.findByUserId(userId)).thenReturn(accounts);
        List<Account> accountsResp = accountController.getAccountsForUser(userId);
        Assertions.assertEquals(accounts.size(), accountsResp.size());
        Assertions.assertEquals(accounts, accountsResp);
    }

    @Test
    public void getTransactionsForAccountWhenAccountIsNull() {
        String accountNum = null;
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getTransactionsForAccount(accountNum));
        Assertions.assertEquals(Constants.INVALID_ACCOUNT,e.getMessage());
    }

    @Test
    public void getTransactionsForAccountWhenAccountIsEmpty() {
        String accountNum = "";
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getTransactionsForAccount(accountNum));
        Assertions.assertEquals(Constants.INVALID_ACCOUNT,e.getMessage());
    }

    @Test
    public void getTransactionsForAccountWhenAccountNotPresent() {
        String accountNum = "account1";
        Mockito.when(accountRepository.findById(accountNum)).thenReturn(Optional.ofNullable(null));
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getTransactionsForAccount(accountNum));
        Assertions.assertEquals(Constants.NO_ACCOUNT_WITH_ACCOUNT_NUMBER,e.getMessage());
    }

    @Test
    public void getTransactionsForAccountWhenAccountAndTransactionPresent(){
        String accountNum = "account1";
        Account account1 = new Account();
        account1.setId("accountNum1");
        account1.setAccountName("accountName1");
        account1.setUserId("UserIdWithAccounts");

        Optional<Account> accounts = Optional.of(account1);

        Mockito.when(accountRepository.findById(accountNum)).thenReturn(accounts);

        Transaction transaction1 = new Transaction();
        transaction1.setAccount(account1);
        transaction1.setAmount(100.00);
        transaction1.setTransactionAction("Debit");
        transaction1.setId("Id1");

        Transaction transaction2 = new Transaction();
        transaction2.setAccount(account1);
        transaction2.setAmount(10000.00);
        transaction2.setTransactionAction("Credit");
        transaction2.setId("Id2");

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        Mockito.when(transactionRepository.findByAccount(account1)).thenReturn(transactions);

        Resources<Transaction> transactionResp = accountController.getTransactionsForAccount(accountNum);
        Assertions.assertEquals(transactions.size(), transactionResp.getContent().size());
    }

    @Test
    public void getTransactionsForAccountWhendTransactionNotPresent() {
        String accountNum = "account1";
        Account account1 = new Account();
        account1.setId("accountNum1");
        account1.setAccountName("accountName1");
        account1.setUserId("UserIdWithAccounts");

        Optional<Account> accounts = Optional.of(account1);

        Mockito.when(accountRepository.findById(accountNum)).thenReturn(accounts);
        Mockito.when(transactionRepository.findByAccount(account1)).thenReturn(null);
        Exception e = Assertions.assertThrows(ServiceException.class,
                ()->accountController.getTransactionsForAccount(accountNum));
        Assertions.assertEquals(Constants.NO_TRANSACTIONS_EXIST,e.getMessage());
    }
}
