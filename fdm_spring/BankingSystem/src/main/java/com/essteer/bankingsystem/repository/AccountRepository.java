package com.essteer.bankingsystem.repository;

import java.util.List;

import com.essteer.bankingsystem.model.User;

@SuppressWarnings("hiding")
public interface AccountRepository<Account, Long> extends IRepository<Account, Long> {

    public List<Account> findByUser(User user);

}
