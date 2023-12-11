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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tableNum;

    @Column
    private String name;

    @Column
    private Long count;

    @Column
    private double price;

    public Orders(Long tableNum, String name, Long count, double price){
        this.tableNum = tableNum;
        this.name = name;
        this.count = count;
        this.price = price;
    }

}
