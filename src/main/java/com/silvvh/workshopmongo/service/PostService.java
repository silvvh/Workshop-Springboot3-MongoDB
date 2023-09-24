package com.silvvh.workshopmongo.service;

import com.silvvh.workshopmongo.domain.Post;
import com.silvvh.workshopmongo.repository.PostRepository;
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
}
