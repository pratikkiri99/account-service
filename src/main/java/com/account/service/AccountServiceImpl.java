package com.account.service;

import com.account.controller.AccountController;
import com.account.dao.AccountRepository;
import com.account.dao.TransactionRepository;
import com.account.exception.ServiceException;
import com.account.model.Account;
import com.account.model.Transaction;
import liquibase.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static com.account.exception.Constants.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Method to get accounts for a user.
     * @param userId
     * @return
     */
    public List<Account> getAccountsForUser(String userId) {

        if (StringUtils.isNotEmpty(userId)) {
            List<Account> accounts = accountRepository.findByUserId(userId);
            if (!CollectionUtils.isEmpty(accounts)) {
                log.info("returning valid user accounts of size ", accounts.size());
                return accounts;
            } else {
                log.warn(NO_ACCOUNT_FOR_USER, userId);
                throw new ServiceException(NO_ACCOUNT_FOR_USER);
            }
        } else {
            log.warn(INVALID_USER, userId);
            throw new ServiceException(INVALID_USER);
        }
    }

    /**
     * Method to get transactions for the given accounts.
     * @param accountNum
     * @return
     */
    public Resources<Transaction> getTransactionsForAccount(String accountNum) {

        if (StringUtils.isNotEmpty(accountNum)) {
            Optional<Account> accountOpt = accountRepository.findById(accountNum);
            if (accountOpt.isPresent()) {
                Account account = accountOpt.get();
                List<Transaction> transactions = transactionRepository.findByAccount(account);
                if (transactions != null && !transactions.isEmpty()) {
                    log.warn("for accountNum {} returning transaction list of size {}",
                            accountNum, transactions.size());
                    String userId = account.getUserId();
                    Link link = linkTo(methodOn(AccountController.class).getAccountsForUser(userId)).withRel("getAccountsForUser");
                    Resources<Transaction> result = new Resources<Transaction>(transactions, link);
                    return result;
                } else {
                    log.warn(NO_TRANSACTIONS_EXIST, accountNum);
                    throw new ServiceException(NO_TRANSACTIONS_EXIST);
                }
            } else {
                log.warn(NO_ACCOUNT_WITH_ACCOUNT_NUMBER, accountNum);
                throw new ServiceException(NO_ACCOUNT_WITH_ACCOUNT_NUMBER);
            }
        } else {
            log.warn(INVALID_ACCOUNT,accountNum);
            throw new ServiceException(INVALID_ACCOUNT);
        }
    }
}
