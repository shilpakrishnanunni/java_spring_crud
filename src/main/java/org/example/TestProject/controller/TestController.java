package org.example.TestProject.controller;

import jakarta.validation.Valid;
import org.example.TestProject.entities.User;
import org.example.TestProject.dto.PatchUserRequest;
import org.example.TestProject.dto.UserRequest;
import org.example.TestProject.exception.UserNotFoundException;
import org.example.TestProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TestController {
    //    private final Map<Long, User> users = new HashMap<>();
//    private Long nextId = 1L;
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> helloPathParam(@PathVariable String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }

    @GetMapping("/hello")
    public String helloQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(
            @Valid @RequestBody UserRequest request
    ) {
        User savedUser = userService.createUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @PutMapping("/users/{id}")
    public User updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request
    ) {
        return userService.updateUser(id, request);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build(); // 204
    }

}

