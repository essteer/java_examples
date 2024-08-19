package com.essteer.bankingsystem.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
        Map<Long, User> users = this.userRepo.getUsers();
        users.put(user.getUserId(), user);
        return user;
    }

    public Account createAccount(Account account) {
        Map<Long, Account> accounts = this.accountRepo.getAccounts();
        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public User createAccountAndUser(User user, Account account) {
        User newUser = this.createUser(user);
        this.createAccount(account);
        return newUser;
    }

    public Optional<User> findUser(Long userId) {
        Map<Long, User> users = this.userRepo.getUsers();
        return Optional.ofNullable(users.get(userId));
    }

    public Optional<Account> findAccount(Long accountNumber) {
        Map<Long, Account> accounts = this.accountRepo.getAccounts();
        return Optional.ofNullable(accounts.get(accountNumber));
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
        Account account = accountRepo.findById(accountNumber).orElse(null);
        if (account != null) {
            BigDecimal balance = account.getBalance();
            BigDecimal newBalance = balance.add(amount);
            account.setBalance(newBalance);
            accountRepo.save(account);
        }

    }

    public void withdrawFromAccount(Long accountNumber, BigDecimal amount) {
        Account account = accountRepo.findById(accountNumber).orElse(null);
        if (account != null) {
            BigDecimal balance = account.getBalance();
            if (amount.compareTo(balance) >= 0) {
                BigDecimal newBalance = balance.subtract(amount);
                account.setBalance(newBalance);
                accountRepo.save(account);
            }
        }
    }

    public void deleteUser(Long userId) {
        if (userRepo.existsById(userId)) {
            User user = userRepo.findById(userId).orElse(null);
            if (user != null) {
                List<Account> userAccounts = accountRepo.findByUser(user);
                for (Account account : userAccounts) {
                    accountRepo.deleteById(account.getAccountNumber());
                }
            }
            userRepo.deleteById(userId);
        }
    }

    public void deleteAccount(Long accountNumber) {
        if (accountRepo.existsById(accountNumber)) {
            Account account = accountRepo.findById(accountNumber).orElse(null);
            if (account != null) {
                User accountOwner = account.getOwner();
                List<Account> ownerAccounts = accountOwner.getAccounts();
                for (Account ac : ownerAccounts) {
                    if (ac.getAccountNumber() == accountNumber) {
                        ownerAccounts.remove(ac);
                        accountOwner.setAccounts(ownerAccounts);
                        break;
                    }
                }
            }
            accountRepo.deleteById(accountNumber);
        }
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
