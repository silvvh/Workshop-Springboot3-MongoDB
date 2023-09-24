package com.silvvh.workshopmongo.config;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.repository.PostRepository;
import com.silvvh.workshopmongo.repository.UserRepository;
import com.silvvh.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.objenesis.instantiator.annotations.Instantiator;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        Post post = new Post(null, LocalDate.of(2018, 3, 21), "Partiu viagem", "Vou para São Paulo", alex);
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.save(post);
    }
}
