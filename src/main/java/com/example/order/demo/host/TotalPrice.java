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
public class TotalPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tableNum;

    @Column
    private double price;

    public TotalPrice(Long tableNum, double price) {
        this.tableNum = tableNum;
        this.price = price;
    }
}
