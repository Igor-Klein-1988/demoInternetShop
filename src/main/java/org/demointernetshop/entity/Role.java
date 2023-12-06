package org.demointernetshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Role {
    public enum Roles {
        ADMIN, CLIENT, MANAGER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private Roles name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
