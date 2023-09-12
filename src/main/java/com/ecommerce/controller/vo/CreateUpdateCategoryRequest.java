package com.ecommerce.controller.vo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateCategoryRequest {
    @NotEmpty(message = "Name of the category must be filled!")
    private String name;
}
