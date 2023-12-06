package com.wpdevs.workshopmongo.services;

import com.wpdevs.workshopmongo.domain.User;
import com.wpdevs.workshopmongo.exceptions.ObjectNotFoundException;
import com.wpdevs.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

}
