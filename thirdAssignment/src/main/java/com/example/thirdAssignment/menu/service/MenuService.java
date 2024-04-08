package com.example.thirdAssignment.menu.service;

import com.example.thirdAssignment.menu.dto.MenuDto;
import com.example.thirdAssignment.menu.entity.Menu;
import com.example.thirdAssignment.menu.repo.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void save(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .menuName(menuDto.getMenuName())
                .menuPrice(menuDto.getMenuPrice())
                .build();
        menuRepository.save(menu);
    }

    public MenuDto read(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElse(null);
        if (menu != null) {
            return MenuDto.builder()
                    .menuName(menu.getMenuName())
                    .menuPrice(menu.getMenuPrice())
                    .build();
        }
        return null;
    }

    public List<MenuDto> readAll() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(menu -> MenuDto.builder()
                        .menuName(menu.getMenuName())
                        .menuPrice(menu.getMenuPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public void update(Long menuId, MenuDto menuDto) {
        Menu menu = menuRepository.findById(menuId).orElse(null);
        if (menu != null) {
            menu.setMenuName(menuDto.getMenuName());
            menu.setMenuPrice(menuDto.getMenuPrice());
            menuRepository.save(menu);
        }
    }

    public void delete(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    public Long getMenuNum(String menuName) {
        Menu menu = menuRepository.findByMenuName(menuName);
        return menu != null ? menu.getMenuId() : null;
    }

    public MenuDto recommendRandomMenu() {
        List<Menu> menus = menuRepository.findAll();
        if (!menus.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(menus.size());
            Menu randomMenu = menus.get(randomIndex);
            return MenuDto.builder()
                    .menuName(randomMenu.getMenuName())
                    .menuPrice(randomMenu.getMenuPrice())
                    .build();
        }
        return null;
    }

    public List<MenuDto> findByPriceLessThan(int price) {
        List<Menu> menus = menuRepository.findByMenuPriceLessThan(price);
        return menus.stream()
                .map(menu -> MenuDto.builder()
                        .menuName(menu.getMenuName())
                        .menuPrice(menu.getMenuPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public List<MenuDto> findByPriceGreaterThan(int price) {
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThan(price);
        return menus.stream()
                .map(menu -> MenuDto.builder()
                        .menuName(menu.getMenuName())
                        .menuPrice(menu.getMenuPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public MenuDto findByName(String menuName) {
        Menu menu = menuRepository.findByMenuName(menuName);
        if (menu != null) {
            return MenuDto.builder()
                    .menuName(menu.getMenuName())
                    .menuPrice(menu.getMenuPrice())
                    .build();
        }
        return null;
    }
}
