package com.essteer.bankingsystem.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.essteer.bankingsystem.model.User;

@Component
@Scope("singleton")
public class UserMapRepository implements UserRepository<User, Long> {

    private Map<Long, User> users;

    public UserMapRepository() {
        super();
        this.users = new HashMap<>();
    }

    public UserMapRepository(Map<Long, User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Users map cannot be null");
        }
        this.users = users;
    }

    @Override
    public User save(User user) {
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findByName(String name) {
        List<User> matchingUsers = new ArrayList<>();
        for (Entry<Long, User> entry : users.entrySet()) {
            if ((entry.getValue()).getName().equalsIgnoreCase(name)) {
                matchingUsers.add(entry.getValue());
            }
        }
        return matchingUsers;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public boolean existsById(Long id) {
        return users.containsKey(id);
    }

    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Users map cannot be null");
        }
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMapRepository [users=" + users + "]";
    }

}
