package org.demointernetshop.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private OrderStatuses status;
    @OneToMany(mappedBy = "orderStatus")
    private List<Order> orders;

    public enum OrderStatuses {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

}
