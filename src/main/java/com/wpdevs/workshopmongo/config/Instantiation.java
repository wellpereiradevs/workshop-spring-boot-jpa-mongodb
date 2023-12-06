package com.wpdevs.workshopmongo.config;

import com.wpdevs.workshopmongo.domain.User;
import com.wpdevs.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "mariabrown@gmail.com");
        User alex = new User(null, "Alex Green", "alexgreen@gmail.com");
        User bob = new User(null, "Bob Grey", "bobgrey@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
    }
}
