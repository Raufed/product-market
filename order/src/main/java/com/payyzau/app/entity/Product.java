package com.payyzau.app.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import org.apache.kafka.common.serialization.Deserializer;

@Entity
@Table(name = "product")
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    public Product(Long id, String name, double price, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
