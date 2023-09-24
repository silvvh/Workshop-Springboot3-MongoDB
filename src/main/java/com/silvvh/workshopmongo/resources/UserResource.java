package com.silvvh.workshopmongo.resources;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.service.UserService;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = service.findAll().stream().map(u -> new UserDTO(u)).toList();
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    UserDTO userDTO = new UserDTO(service.findById(id));
    return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI url = ServletUriComponentsBuilder.fromCurrentRequestUri().buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
