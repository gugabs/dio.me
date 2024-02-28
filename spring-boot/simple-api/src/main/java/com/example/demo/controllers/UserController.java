package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserRepository userRepository;

  @PostMapping
  public User save(@RequestBody User user) {
    return userRepository.save(user);
  }

  @GetMapping
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/{username}")
  public User findOneByUsername(@PathVariable("username") String username) {
    return userRepository.findOneByUsername(username);
  }

  @DeleteMapping("/{id}")
  public User deleteById(@PathVariable("id") Integer id) {
    return userRepository.deleteById(id);
  }
}
