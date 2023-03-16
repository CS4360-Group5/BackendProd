package edu.msudenver.services;

import edu.msudenver.models.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    void deleteAccount(Long id);
}