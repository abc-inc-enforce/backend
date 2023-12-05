package com.example.order.demo.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 모든 메뉴 조회
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // 특정 메뉴 조회
    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // 메뉴 추가
    @PostMapping
    public Menu addMenu(@RequestBody MenuRequest menuRequest) {
        return menuService.addMenu(menuRequest.getName(), menuRequest.getDescription(), menuRequest.getPrice());
    }

    // 메뉴 수정
    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody MenuRequest menuRequest) {
        return menuService.updateMenu(id, menuRequest.getName(), menuRequest.getDescription(), menuRequest.getPrice());
    }

    // 메뉴 삭제
    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}

