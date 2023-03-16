package edu.msudenver.services;

import edu.msudenver.models.Account;
import edu.msudenver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (existingAccount == null) {
            return null;
        }
        existingAccount.setEmail(account.getEmail());
        existingAccount.setGamerTag(account.getGamerTag());
        existingAccount.setPassword(account.getPassword());
        existingAccount.setStatus(account.getStatus());
        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
