package com.example.order.demo.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public List<Orders> addOrders(@RequestBody List<OrdersRequest> ordersRequests) {
        List<Orders> orders = new ArrayList<>();

        for (OrdersRequest ordersRequest : ordersRequests) {
            Orders order = ordersService.addOrder(
                    ordersRequest.getTableNum(),
                    ordersRequest.getName(),
                    ordersRequest.getCount(),
                    ordersRequest.getPrice()
            );
            orders.add(order);
        }

        return orders;
    }


    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{tableNum}")
    public List<Orders> getOrdersAllByTableNum(@PathVariable Long tableNum) {
        return ordersService.getOrdersAllByTableNum(tableNum);
    }

    @DeleteMapping("/{tableNum}")
    public void deleteOrders(@PathVariable Long tableNum) { ordersService.deleteOrders(tableNum); }

}
