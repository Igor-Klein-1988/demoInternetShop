package org.demointernetshop.dto.product;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demointernetshop.dto.ManufacturerDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Product", description = "Product data")
public class ProductDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    String name;
    @Schema(description = "Description of the product", example = "Latest iPhone model")
    String description;
    @Schema(description = "Category of the product", example = "Smartphones")
    String categoryName;
    @Schema(description = "Manufacturer of the product")
    ManufacturerDto manufacturer;
}