package com.example.springboot.domain.product.dto;

import com.example.springboot.domain.product.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;

public record ProductDto(@NotBlank String name, @NotNull BigDecimal price) {

}
