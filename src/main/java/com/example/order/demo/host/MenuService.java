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

    public Menu addMenu(String name, String description, double price) {
        Menu menu = new Menu( name,  description,  price);
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, String name, String description, double price) {
        Menu existingMenu = menuRepository.findById(id);
        if (existingMenu != null) {
            existingMenu.updateMenu(name, description, price);
            return menuRepository.save(existingMenu);
        }
        return null; // 혹은 예외 처리
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id);
    }
}
