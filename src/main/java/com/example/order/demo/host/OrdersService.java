package com.example.order.demo.host;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders addOrder(Long tableNum, String name, Long count, double price) {
        Orders orders = new Orders( tableNum, name, count, price);
        return ordersRepository.save(orders);
    }

    @Transactional
    public void deleteOrders(Long tableNum) {
        ordersRepository.deleteAllByTableNum(tableNum);
    }

    public List<Orders> getAllOrders() { return ordersRepository.findAll(); }

    public List<Orders> getOrdersAllByTableNum(Long tableNum) {
        List<Orders> ordersList = ordersRepository.findAllByTableNum(tableNum);
        return ordersList != null ? ordersList : Collections.emptyList();
    }

}
