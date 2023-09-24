package com.silvvh.workshopmongo.config;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.repository.PostRepository;
import com.silvvh.workshopmongo.repository.UserRepository;
import dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args)  {

        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        Post post1 = new Post(null, LocalDate.of(2023, 4, 21), "Partiu viagem", "Vou para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2023, 12, 20), "Enfim férias", "Bora de aproveitar o descanso!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
