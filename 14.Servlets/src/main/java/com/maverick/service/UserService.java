package com.maverick.service;

import com.maverick.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> userDb;

    public UserService() {
        userDb = new HashMap<>();
    }

    public User createUser(User user) {
        userDb.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        for (User user : userDb.values()) {
            list.add(user);
        }
        return list;
    }

    public User getUserById(Integer id) {
        return userDb.get(id);
    }
}
