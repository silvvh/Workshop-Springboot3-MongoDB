package com.silvvh.workshopmongo.service;

import com.silvvh.workshopmongo.domain.User;
import com.silvvh.workshopmongo.repository.UserRepository;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> userOptional = repository.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User fromDTO(UserDTO dto) {
        User user = new User(dto.getId(), dto.getName(), dto.getEmail());
        return user;
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user, String id) {
        User actual = findById(id);
        updateData(actual, user);
        return repository.save(actual);
    }

    public void updateData(User actual, User changed) {
        actual.setName(changed.getName());
        actual.setEmail(changed.getEmail());
    }
}
