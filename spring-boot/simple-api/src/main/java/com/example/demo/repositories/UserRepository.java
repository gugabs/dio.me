package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public class UserRepository {
  List<User> users = new ArrayList<>();

  public User save(User user) {
    users.add(user);
    return user;
  }

  public List<User> findAll() {
    return users;
  }

  public User findOneByUsername(String username) {
    return users.stream()
        .filter(user -> user.getUsername().equals(username))
        .findFirst()
        .orElse(null);
  }

  public User deleteById(Integer id) {
    User userToDelete = users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElse(null);

    if (userToDelete != null) {
      users.remove(userToDelete);
    }

    return userToDelete;
  }
}
