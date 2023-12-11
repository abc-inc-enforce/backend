package com.example.order.demo.host;

import lombok.Getter;

@Getter
public class TotalPriceRequest {
    private Long tableNum;
    private double price;
}
