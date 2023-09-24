package com.silvvh.workshopmongo.resources;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}