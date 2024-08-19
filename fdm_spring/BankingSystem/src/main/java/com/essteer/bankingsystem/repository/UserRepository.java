package com.essteer.bankingsystem.repository;

import java.util.List;

@SuppressWarnings("hiding")
public interface UserRepository<User, Long> extends IRepository<User, Long> {

    public List<User> findByName(String name);

}
