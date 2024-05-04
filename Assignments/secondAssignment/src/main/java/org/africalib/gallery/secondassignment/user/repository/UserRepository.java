package org.africalib.gallery.secondassignment.menu.repository;

import org.africalib.gallery.secondseminar.menu.Menu;
import org.africalib.gallery.secondseminar.menu.dto.MenuDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MenuRepository {
    private static final Map<Integer, Menu> menuMap = new HashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public void save(MenuDto menuDto) {
        int id = idCounter.incrementAndGet();
        Menu menu = Menu.builder()
                .id(id)
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .build();
        menuMap.put(id, menu);
    }
    public MenuDto findById(Integer id){
        Menu menu = handong.get(id);
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .build();
    }
    public List<MenuDto> findAll(){
        return handong.values().stream()
                .map(menu -> MenuDto.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .build()).toList();
    }

    public void update(Integer id, MenuDto menuDto){
        Menu menu = handong.get(id);
        menu.setId(menuDto.getId());
        menu.setName(menuDto.getName());
        menu.setPrice(menuDto.getPrice());
    }

    public void delete(Integer id){
        handong.remove(id);
    }
}
