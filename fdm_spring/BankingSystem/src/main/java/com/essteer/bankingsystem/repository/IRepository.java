package com.essteer.bankingsystem.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {

    public T save(T type);

    public Optional<T> findById(ID id);

    public List<T> findAll();

    public boolean existsById(ID id);

    public void deleteById(ID id);

}
