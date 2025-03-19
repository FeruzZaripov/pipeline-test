package com.example.cicd;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@gmail.com");
            userRepository.save(user);
        }
    }
}
