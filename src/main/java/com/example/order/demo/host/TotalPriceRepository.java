package com.example.order.demo.host;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalPriceRepository extends JpaRepository<TotalPrice, Long> {
    List<TotalPrice> findAllByTableNum(Long tableNum);

    void deleteAllByTableNum(Long tableNum);
}
