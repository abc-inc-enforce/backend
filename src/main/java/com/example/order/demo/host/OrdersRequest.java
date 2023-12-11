package com.example.order.demo.host;

import lombok.Getter;

@Getter
public class OrdersRequest {
    private Long tableNum;
    private String name;
    private Long count;
    private double price;
}
