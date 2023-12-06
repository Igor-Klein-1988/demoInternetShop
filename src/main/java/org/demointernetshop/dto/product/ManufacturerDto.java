package org.demointernetshop.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Manufacturer", description = "Manufacturer data")

public class ManufacturerDto {
    @Schema(description = "Manufacturer identifier", example = "1")
    Integer id;
    @Schema(description = "Name of the manufacturer", example = "Apple")
    String name;

    @Schema(description = "Country of the manufacturer", example = "USA")
    String country;
}