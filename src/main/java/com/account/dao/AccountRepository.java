package com.account.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

	/**
	 * DAO to find all accounts for the given user.
	 * @param userId
	 * @return list of account
	 */
	List<Account> findByUserId(String userId);
	
}
