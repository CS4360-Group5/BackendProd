package edu.msudenver.services;

import edu.msudenver.models.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    void deleteAccount(Long id);

    Account getAccountByEmail(String email);

    Account getAccountBygamerTag(String gamerTag);
}