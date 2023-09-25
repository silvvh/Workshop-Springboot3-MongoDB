package com.silvvh.workshopmongo.resources;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.service.PostService;
import dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value="/{id}/comments")
    public ResponseEntity<List<CommentDTO>> findPosts(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post.getComments());
    }
}