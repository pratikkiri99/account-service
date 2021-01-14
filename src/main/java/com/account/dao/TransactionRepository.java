package com.account.dao;

import com.account.model.Account;
import com.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    /**
     * find list of transaction by given account.
     * @param account
     * @return
     */
    List<Transaction> findByAccount(Account account);
}
