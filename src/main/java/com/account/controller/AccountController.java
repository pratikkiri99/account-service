package com.account.controller;

import com.account.dao.AccountRepository;
import com.account.dao.TransactionRepository;
import com.account.exception.ServiceException;
import com.account.model.Account;
import com.account.model.Transaction;
import liquibase.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.account.exception.Constants.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * RestController to expose account related services.
 */
@Slf4j
@RestController()
public class AccountController {


	AccountRepository accountRepository;

	TransactionRepository transactionRepository;

	public AccountController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	/**
	 * Endpoint to get accounts for a person
	 * @param userId
	 * @return list of accounts
	 */
	@GetMapping("/accounts")
	public List<Account> getAccountsForUser(@RequestParam String userId) {
		
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
	 * Endpoint to get transactions for the given account
	 * Link to go back account detail with ref link
	 * @param accountNum
	 * @return list of transactions
	 */
	@GetMapping("/accounts/{accountNum}/transactions")
	public Resources<Transaction> getTransactionsForAccount(@PathVariable("accountNum") String accountNum) {
		
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
