package org.demointernetshop.controllers.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.demointernetshop.dto.StandardResponseDto;
import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserUpdateDto;
import org.demointernetshop.validation.dto.ValidationErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@Tags(value = {@Tag(name = "Users")})
public interface UsersApi {
    @Operation(summary = "User Registration", description = "Available to everyone. Default role is Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "User registered",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Validation error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class))),
            @ApiResponse(responseCode = "409",
                    description = "User with this email already exists",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class))),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    UserDto register(@RequestBody @Valid UserRegistrationDto request);
    //    Put: updateUser

    @Operation(summary = "User Update", description = "Available to everyone.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Validation error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class))),
            @ApiResponse(responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class))),
            @ApiResponse(responseCode = "409",
                    description = "User with this email already exists",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class))),
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{userId}")
    UserDto updateUser(@RequestBody @Valid UserUpdateDto request,
                       @Parameter(description = "User identifier", example = "1")
                       @PathVariable @NotNull(message = "User ID is required") Integer userId);

    @Operation(summary = "Get user", description = "Available to everyone.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
            ),
            @ApiResponse(responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class)))
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    UserDto getUser(@Parameter(name = "userId", description = "User identifier", example = "1")
                    @PathVariable("userId") Integer userId);

    @Operation(summary = "Delete user", description = "Available to everyone.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
            ),
            @ApiResponse(responseCode = "404",
                    description = "User not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class)))
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{userId}")
    UserDto archived(@Parameter(name = "userId", description = "User identifier", example = "1")
                     @PathVariable("userId") Integer userId);
}
