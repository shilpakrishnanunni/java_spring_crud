package org.example.TestProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PatchUserRequest(
        String name,
        @Email String email,
        @Min(18) Integer age
) {}
