package org.demointernetshop.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.demointernetshop.dto.product.ProductCartInfoDto;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
    @Schema(description = "User info")
    UserDto user;

//    @Schema(description = "Products", example = "14")
//    List<ProductCartInfoDto> products;

    @Schema(description = "Description of the product", example = "Latest iPhone model")
    String description;
    @Schema(description = "Price of the product", example = "1500.0")
    BigDecimal productPrice;
    @Schema(description = "Quantity of the product", example = "24")
    int productQuantity;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;
    private LocalDateTime createData;

}
