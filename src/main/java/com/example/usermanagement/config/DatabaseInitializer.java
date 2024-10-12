package com.example.usermanagement.config;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User adminUser = new User();
            adminUser.setUsername("vivek");
            adminUser.setPassword(passwordEncoder.encode("vivek1234"));
            adminUser.setRole(User.Role.ADMIN);
            userRepository.save(adminUser);
        }
    }
}

