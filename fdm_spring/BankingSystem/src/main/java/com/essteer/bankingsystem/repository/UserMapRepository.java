package com.essteer.bankingsystem.repository;

import java.util.ArrayList;
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
    }

    public UserMapRepository(Map<Long, User> users) {
        this.users = users;
    }

    public User save(User user) {
        users.put(user.getUserId(), user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<User> findByName(String name) {
        List<User> matchingUsers = new ArrayList<>();
        for (Entry<Long, User> entry : users.entrySet()) {
            if (((com.essteer.bankingsystem.model.User) entry.getValue()).getName().equals(name)) {
                matchingUsers.add(entry.getValue());
            }
        }
        return matchingUsers;
    }

    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        for (Entry<Long, User> entry : users.entrySet()) {
            allUsers.add(entry.getValue());
        }
        return allUsers;
    }

    public boolean existsById(Long id) {
        return users.containsKey(id);
    }

    public void deleteById(Long id) {
        users.remove(id);
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMapRepository [users=" + users + "]";
    }

}
