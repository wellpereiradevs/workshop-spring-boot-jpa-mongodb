package com.wpdevs.workshopmongo.repositories;

import com.wpdevs.workshopmongo.domain.Post;
import com.wpdevs.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
