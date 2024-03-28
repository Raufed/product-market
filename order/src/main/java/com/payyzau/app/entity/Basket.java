package com.payyzau.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "basket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "products")
    @OneToMany(mappedBy = "basket")
    private List<Product> products;

    @Column(name = "promo_code")
    private String promoCode;

}
