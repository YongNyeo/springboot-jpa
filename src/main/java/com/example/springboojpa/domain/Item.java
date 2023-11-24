package com.example.springboojpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setItem(this);
    }
}