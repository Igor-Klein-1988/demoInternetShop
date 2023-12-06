package org.demointernetshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.demointernetshop.dto.product.ProductCartInfoDto;

import java.util.List;

@Schema(name = "Cart", description = "Cart data")
public class CartDto {
    @Schema(description = "Cart identifier", example = "1")
    private Integer id;
    @Schema(description = "User identifier", example = "14")
    private Integer userId;
    @Schema(description = "Products", example = "14")
    List<ProductCartInfoDto> products;
}
