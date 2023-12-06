package com.example.order.demo.host;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private double price;

    public void updateMenu(String name , double price) {
        this.name = name;
        this.price = price;
    }
    public Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

}