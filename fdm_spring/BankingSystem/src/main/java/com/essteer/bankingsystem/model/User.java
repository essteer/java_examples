package com.essteer.bankingsystem.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {

    private long userId;
    private String name;
    private List<Account> accounts;

    public User() {
        super();
    }

    public User(long userId, String name, List<Account> accounts) {
        this.userId = userId;
        this.name = name;
        this.accounts = accounts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", accounts=" + accounts + "]";
    }

}
