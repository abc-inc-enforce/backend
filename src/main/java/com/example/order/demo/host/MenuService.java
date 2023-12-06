package com.example.order.demo.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu addMenu(String name, double price) {
        Menu menu = new Menu( name,  price);
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, String name, double price) {
        Menu existingMenu = menuRepository.findById(id)
                .orElseThrow();
        existingMenu.updateMenu(name, price);
        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow();
    }
}
