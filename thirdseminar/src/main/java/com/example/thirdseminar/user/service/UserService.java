package com.example.thirdAssignment.menu.service;

import com.example.thirdAssignment.menu.dto.MenuDto;
import com.example.thirdAssignment.menu.entity.Menu;
import com.example.thirdAssignment.menu.repo.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class MenuService {
    private final MenuRepository menuRepository;
    public void save(MenuDto menuDto){
        Menu menu = Menu.builder()
                .menuMenuName(menuDto.getMenuName())
                .menuPrice(menuDto.getmenuPrice())
                .build();
        menuRepository.save(menu);
    }
    public MenuDto read(Long menuId){
        Menu menu = menuRepository.findById(menuId).get();
        return MenuDto.builder()
                .menuName(menu.getMenuMenuName())
                .menuPrice(menu.getmenuPrice())
                .build();
    }
    public List<MenuDto> readAll() {
        List<Menu> menus = menuRepository.findAll();
        List<MenuDto> menuDtos = menus.stream().map(menu ->
                MenuDto.builder()
                        .menuName(menu.getMenuMenuName())
                        .menuPrice(menu.getmenuPrice())
                        .build()).toList();
        return menuDtos;
    }

    public void update(Long menuId, MenuDto menuDto){
        Menu menu = menuRepository.findById(menuId).get();
        menu.setMenuMenuName(menuDto.getMenuName());
        menu.setmenuPrice(menuDto.getmenuPrice());
        menuRepository.save(menu);
    }
    public void delete(Long menuId){
        menuRepository.deleteById(menuId);
    }
    //menuName로 menuId찾기
    public Long getMenuNum(String menuName){
        Menu menu=menuRepository.findByMenuMenuName(menuName);
        return menu.getmenuId();

    }
}
