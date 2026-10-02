package org.example.TermProject.service;

import org.example.TermProject.dto.AuthResponse;
import org.example.TermProject.dto.LoginRequest;
import org.example.TermProject.dto.LoginResponse;
import org.example.TermProject.dto.RegisterRequest;
import org.example.TermProject.entities.Role;
import org.example.TermProject.entities.User;
import org.example.TermProject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password()),
                Role.USER
        );

        User savedUser = userRepository.save(user);

        return new AuthResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
