package com.example.order.demo.host;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository {
    Menu save(Menu menu);
    Menu findById(Long id);
    List<Menu> findAll();
    void deleteById(Long id);
}