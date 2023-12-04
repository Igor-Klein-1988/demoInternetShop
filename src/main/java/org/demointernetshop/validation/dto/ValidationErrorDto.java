package org.demointernetshop.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ValidationError", description = "Validation error description")
public class ValidationErrorDto {
    @Schema(description = "Name of the field where the error occurred", example = "email")
    private String field;
    @Schema(description = "Value entered by the user that was rejected by the server", example = "usermail.com")
    private String rejectedValue;
    @Schema(description = "Message that should be shown to the user", example = "Email should be valid")
    private String message;
}