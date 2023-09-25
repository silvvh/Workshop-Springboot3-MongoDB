package com.silvvh.workshopmongo.config;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.repository.PostRepository;
import com.silvvh.workshopmongo.repository.UserRepository;
import dto.AuthorDTO;
import dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        Post post1 = new Post(null, LocalDate.of(2023, 4, 21), "Partiu viagem", "Vou para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2023, 12, 20), "Enfim férias", "Bora de aproveitar o descanso!", new AuthorDTO(maria));
        post1.getComments().add(new CommentDTO("Boa viagem, mano!", LocalDate.of(2023, 4, 21), new AuthorDTO(alex)));
        post1.getComments().add(new CommentDTO("Espero que se divirta", LocalDate.of(2023, 8, 23), new AuthorDTO(bob)));
        post2.getComments().add(new CommentDTO("Aí sim!", LocalDate.of(2023, 12, 21), new AuthorDTO(maria)));
        post2.getComments().add(new CommentDTO("Aproveite bem", LocalDate.of(2023, 12, 25), new AuthorDTO(bob)));
        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}