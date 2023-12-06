package org.demointernetshop.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Category", description = "Category data")
public class CategoryDto {
    @Schema(description = "Category identifier", example = "1")
    Integer id;
    @Schema(description = "Name of the Category", example = "smartphones")
    String categoryName;
}
