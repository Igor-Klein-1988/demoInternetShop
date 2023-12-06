package org.demointernetshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private PaymentStatuses status;
    @OneToMany(mappedBy = "paymentStatus")
    private List<Order> orders;

    public enum PaymentStatuses {
        AWAITING_PAYMENT,
        PAID,
        DECLINED,
        REFUNDED
    }
}
