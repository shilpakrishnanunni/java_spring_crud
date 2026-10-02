package org.example.TermProject.dto;

import java.math.BigDecimal;

public record MenuItemResponse(
        Long categoryId,
        String categoryName,
        String name,
        String description,
        BigDecimal price,
        String imageUrl
) {}
