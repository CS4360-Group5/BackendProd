package edu.msudenver.controllers;

import edu.msudenver.exceptions.EmailAlreadyInUseException;
import edu.msudenver.models.Account;
import edu.msudenver.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        Account existingAccount = accountService.getAccountByEmail(account.getEmail());
        if (existingAccount != null) {
            throw new EmailAlreadyInUseException("Email address is already in use");
        }
        Account existingAccount2 = accountService.getAccountBygamerTag(account.getGamerTag());
        if (existingAccount2 != null) {
            throw new EmailAlreadyInUseException("Gamer Tag is already in use");
        }

        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(accountId, account);
        if (updatedAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/login/{accountId}")
    public ResponseEntity<String> accountLogin(@PathVariable Long accountId, @RequestBody Account account) {
        // Check if the email and password are valid
        if (isValidEmail(account.getEmail()) && isValidPassword(account.getPassword())) {
            // Authenticate the user's email and password
            boolean isAuthenticated = accountService.authenticateUser(account.getEmail(), account.getPassword());

            if (isAuthenticated) {
                // Update the user's status to "active"
                account.setStatus("Online");

                // Update the user's record in the database
                try {
                    accountService.updateOnline(accountId, account);
                    return ResponseEntity.ok("Login successful.");
                } catch (Exception ex) {
                    return ResponseEntity.internalServerError().body("Error updating account: " + ex.getMessage());
                }
            } else {
                return ResponseEntity.badRequest().body("Invalid email or password.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password.");
        }
    }

    @PutMapping("/logOut/{accountId}")
    public ResponseEntity<String> accountLogout(@PathVariable Long accountId, @RequestBody Account account) {
        // Check if the email and password are valid
        if (isValidEmail(account.getEmail()) && isValidPassword(account.getPassword())) {
            // Authenticate the user's email and password
            boolean isAuthenticated = accountService.authenticateUser(account.getEmail(), account.getPassword());

            if (isAuthenticated) {
                // Update the user's status to "active"
                account.setStatus("Offline");

                // Update the user's record in the database
                try {
                    accountService.updateOnline(accountId, account);
                    return ResponseEntity.ok("Logout successful.");
                } catch (Exception ex) {
                    return ResponseEntity.internalServerError().body("Error updating account: " + ex.getMessage());
                }
            } else {
                return ResponseEntity.badRequest().body("Invalid email or password.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password.");
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // Validate password length
        if (password.length() < 8) {
            return false;
        }

        // Validate password complexity
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit;
    }
}
