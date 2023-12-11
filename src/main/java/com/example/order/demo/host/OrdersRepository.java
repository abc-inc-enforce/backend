package com.example.order.demo.host;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByTableNum(Long tableNum);

    void deleteAllByTableNum(Long tableNum);
}
