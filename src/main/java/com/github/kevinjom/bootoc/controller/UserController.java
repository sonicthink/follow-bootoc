package com.github.kevinjom.bootoc.controller;

import com.github.kevinjom.bootoc.domain.User;
import com.github.kevinjom.bootoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public List<User> listAll(@RequestParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return userRepository.findByName(name.get());
        }
        return userRepository.findAll();
    }
}
