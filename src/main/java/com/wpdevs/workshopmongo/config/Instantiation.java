package com.wpdevs.workshopmongo.config;

import com.wpdevs.workshopmongo.DTO.AuthorDTO;
import com.wpdevs.workshopmongo.domain.Post;
import com.wpdevs.workshopmongo.domain.User;
import com.wpdevs.workshopmongo.repositories.PostRepository;
import com.wpdevs.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "mariabrown@gmail.com");
        User alex = new User(null, "Alex Green", "alexgreen@gmail.com");
        User bob = new User(null, "Bob Grey", "bobgrey@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPost().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
