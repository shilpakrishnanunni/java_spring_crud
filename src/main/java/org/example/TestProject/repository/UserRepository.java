package org.example.TestProject.repository;

import org.example.TestProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    userRepository.findAll();
//    userRepository.findById(id);
//    userRepository.save(user);
//    userRepository.delete(user);
//    userRepository.existsById(id);
}
