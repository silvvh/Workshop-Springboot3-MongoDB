package com.silvvh.workshopmongo.resources;

import com.silvvh.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User ("test1", "name1", "name123@test.com"));
        users.add(new User ("test2", "name2", "name456@test.com"));
        users.add(new User ("test3", "name3", "name789@test.com"));
        return ResponseEntity.ok().body(users);
    }
}
