package com.essteer.bankingsystem.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.essteer.bankingsystem.model.Account;
import com.essteer.bankingsystem.model.User;

@Component
@Scope("singleton")
public class Teller {

    private UserMapRepository userRepo;
    private AccountMapRepository accountRepo;

    public Teller(UserMapRepository userRepo, AccountMapRepository accountRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public User createAccountAndUser(User user, Account account) {
        User newUser = this.createUser(user);
        this.createAccount(account);
        return newUser;
    }

    public Optional<User> findUser(Long userId) {
        return userRepo.findById(userId);
    }

    public Optional<Account> findAccount(Long accountNumber) {
        return accountRepo.findById(accountNumber);
    }

    public User updateUser(User user) {
        userRepo.save(user);
        return user;
    }

    public Account updateAccount(Account account) {
        accountRepo.save(account);
        return account;
    }

    public void depositInAccount(Long accountNumber, BigDecimal amount) {
        accountRepo.findById(accountNumber).ifPresent(account -> {
            account.setBalance(account.getBalance().add(amount));
            accountRepo.save(account);
        });
    }

    public void withdrawFromAccount(Long accountNumber, BigDecimal amount) {
        accountRepo.findById(accountNumber).ifPresent(account -> {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(amount) >= 0) {
                account.setBalance(balance.subtract(amount));
                accountRepo.save(account);
            }
        });
    }

    public void deleteUser(Long userId) {
        userRepo.findById(userId).ifPresent(user -> {
            accountRepo.findByUser(user).forEach(account -> accountRepo.deleteById(account.getAccountNumber()));
            userRepo.deleteById(userId);
        });
    }

    public void deleteAccount(Long accountNumber) {
        accountRepo.findById(accountNumber).ifPresent(account -> {
            User accountOwner = account.getOwner();
            accountOwner.getAccounts().removeIf(ac -> ac.getAccountNumber() == accountNumber);
            accountRepo.deleteById(accountNumber);
        });
    }

    public UserMapRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserMapRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AccountMapRepository getAccountRepo() {
        return accountRepo;
    }

    public void setAccountRepo(AccountMapRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

}
