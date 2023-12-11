package com.example.order.demo.host;

import com.example.order.demo.host.Menu;
import com.example.order.demo.host.MenuRepository;
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

    public Menu addMenu(String img, String name, String category, double price) {
        Menu menu = new Menu( img, name,  category, price);
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, String img, String name, String category, double price) {
        Menu existingMenu = menuRepository.findById(id)
                .orElseThrow();
        existingMenu.updateMenu(img, name, category, price);
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
