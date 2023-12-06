package org.demointernetshop.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.demointernetshop.dto.product.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/products")
@Tags(value = {@Tag(name = "Products")})
public interface ProductApi {
    @Operation(summary = "Get all products", description = "Available to everyone.")
    @GetMapping
    List<ProductDto> getProducts();
}
