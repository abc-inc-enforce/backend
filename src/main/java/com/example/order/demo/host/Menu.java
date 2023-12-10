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
    private String img;

    @Column
    private String category;

    @Column
    private double price;

    public void updateMenu(String img, String name ,String category, double price) {
        this.img = img;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public Menu(String img, String name, String category, double price) {
        this.img = img;
        this.name = name;
        this.category = category;
        this.price = price;
    }

}