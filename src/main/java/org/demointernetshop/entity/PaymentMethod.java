package org.demointernetshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private PaymentMethods method;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Order> orders;

    public enum PaymentMethods {
        CREDIT_CARD,
        PAYPAL,
        BANK_TRANSFER,
        CASH_ON_DELIVERY,
        DIGITAL_WALLET
    }
}
