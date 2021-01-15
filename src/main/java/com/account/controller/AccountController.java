package com.account.controller;

import com.account.model.Account;
import com.account.model.Transaction;
import com.account.service.AccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController to expose account related services.
 */
@Slf4j
@Api(value = "Account Service API")
@RestController()
@RequestMapping("/api")
public class AccountController {


	AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	/*@GetMapping()
	public String welcomeMessage() {
		return "Welcome to account service";
	}*/

	/**
	 * Endpoint to get accounts for a person
	 * @param userId
	 * @return list of accounts
	 */
	@GetMapping("/accounts")
	public List<Account> getAccountsForUser(@RequestParam String userId) {
		return accountService.getAccountsForUser(userId);
	}

	/**
	 * Endpoint to get transactions for the given account
	 * Link to go back account detail with ref link
	 * @param accountNum
	 * @return list of transactions
	 */
	@GetMapping("/accounts/{accountNum}/transactions")
	public Resources<Transaction> getTransactionsForAccount(@PathVariable("accountNum") String accountNum) {
		return accountService.getTransactionsForAccount(accountNum);
	}
	
}
