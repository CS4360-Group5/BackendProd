package edu.msudenver.services;

import edu.msudenver.models.Account;
import edu.msudenver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
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

    @Override
    public Account getAccountByEmail(String email){
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account getAccountBygamerTag(String gamerTag){
        return accountRepository.findBygamerTag(gamerTag);
    }

    @Override
    public Account updateOnline(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (existingAccount == null) {
            return null;
        }
        existingAccount.setStatus("Online");
        return accountRepository.save(existingAccount);
    }

    @Override
    public Account updateOffline(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (existingAccount == null) {
            return null;
        }
        existingAccount.setStatus("Online");
        return accountRepository.save(existingAccount);
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        // Find the account by email
        Account account = accountRepository.findByEmail(email);

        // If account is null, the user is not authenticated
        if (account == null) {
            return false;
        }

        return password == account.getPassword();
    }
}
