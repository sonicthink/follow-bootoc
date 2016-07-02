package com.github.kevinjom.bootoc.config;


import com.github.kevinjom.bootoc.domain.User;
import com.github.kevinjom.bootoc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@EnableJpaRepositories(basePackages = "com.github.kevinjom.bootoc.repository")
@Configuration
public class RepositoryConfiguration {
    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            List<User> users = Arrays.asList("kevin,joyce,dave,kg".split(",")).stream().map(name -> new User(name)).collect(Collectors.toList());
            userRepository.save(users);
        };
    }
}
