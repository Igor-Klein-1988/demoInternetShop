package org.demointernetshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Manufacturer", description = "Manufacturer data")

public class ManufacturerDto {
    @Schema(description = "Name of the manufacturer", example = "Apple")
    String name;

    @Schema(description = "Name of the country", example = "USA")
    String country;
}