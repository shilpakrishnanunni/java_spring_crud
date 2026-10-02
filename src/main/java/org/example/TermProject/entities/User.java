package org.example.TermProject.entities;

import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(
            String name,
            String email,
            String password,
            Integer age,
            Role role
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() { return password; }

    public void setPassword(@Nullable String encode) { this.password = encode; }

    public void setRole(Role role) { this.role = role; }

    public Role getRole() { return role; }

    public Long getId() { return id; }

}
