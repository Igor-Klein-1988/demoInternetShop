package org.demointernetshop.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(name = "ProductShort", description = "Product data")

public class ProductCartInfoDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    String name;
    @Schema(description = "Price of the product", example = "1500.0")
    BigDecimal price;
    @Schema(description = "Quantity of the product", example = "24")
    int quantity;
}
