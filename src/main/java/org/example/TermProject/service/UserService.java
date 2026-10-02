package org.example.TermProject.service;

import org.example.TermProject.dto.UserRequest;
import org.example.TermProject.entities.User;
import org.example.TermProject.exception.UserNotFoundException;
import org.example.TermProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(UserRequest request){
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setAge(request.age());

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequest request) {
        User user = getUser(id);

        user.setName(request.name());
        user.setEmail(request.email());
        user.setAge(request.age());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }
}
