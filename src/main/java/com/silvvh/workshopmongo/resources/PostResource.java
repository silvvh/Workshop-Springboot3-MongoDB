package com.silvvh.workshopmongo.resources;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.resources.util.URL;
import com.silvvh.workshopmongo.service.PostService;
import dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")

public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<CommentDTO>> findPosts(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post.getComments());
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByTitle(text));
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text") String text,
            @RequestParam(value = "") String minDate,
            @RequestParam(value = "") String maxDate) {
        text = URL.decodeParam(text);
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());
        LocalDate min = URL.convertDate(minDate, LocalDate.now());
        List<Post> posts = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }

}