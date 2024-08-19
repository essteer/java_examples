package com.essteer.bankingsystem.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.essteer.bankingsystem.model.Account;
import com.essteer.bankingsystem.model.User;

@Component
@Scope("singleton")
public class AccountMapRepository implements AccountRepository<Account, Long> {

    private Map<Long, Account> accounts;

    public AccountMapRepository() {
        super();
    }

    public AccountMapRepository(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    public Account save(Account account) {
        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public List<Account> findByUser(User user) {
        List<Account> userAccounts = new ArrayList<>();
        for (Entry<Long, Account> entry : accounts.entrySet()) {
            if (((com.essteer.bankingsystem.model.Account) entry.getValue()).getOwner().equals(user)) {
                userAccounts.add(entry.getValue());
            }
        }
        return userAccounts;
    }

    public List<Account> findAll() {
        List<Account> allAccounts = new ArrayList<>();
        for (Entry<Long, Account> entry : accounts.entrySet()) {
            allAccounts.add(entry.getValue());
        }
        return allAccounts;
    }

    public boolean existsById(Long id) {
        return accounts.containsKey(id);
    }

    public void deleteById(Long id) {
        accounts.remove(id);
    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "AccountMapRepository [accounts=" + accounts + "]";
    }

}
