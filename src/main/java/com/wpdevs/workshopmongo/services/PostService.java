package com.wpdevs.workshopmongo.services;

import com.wpdevs.workshopmongo.domain.Post;
import com.wpdevs.workshopmongo.exceptions.ObjectNotFoundException;
import com.wpdevs.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Post user = repository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}

