package org.africalib.gallery.secondseminar.menu.repository;

import org.africalib.gallery.secondseminar.menu.Menu;
import org.africalib.gallery.secondseminar.menu.dto.MenuDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MenuRepository {
    private static final Map<Integer, Menu> handong = new HashMap<>();
    public void save(MenuDto menuDto){
        Menu u = Menu.builder()
                .studentId(menuDto.getStudentId())
                .studentName(menuDto.getStudentName())
                .build();
        handong.put(menuDto.getStudentId(), u);
    }
    public MenuDto findById(Integer studentId){
        Menu menu = handong.get(studentId);
        return MenuDto.builder()
                .studentId(menu.getStudentId())
                .studentName(menu.getStudentName())
                .build();
    }
    public List<MenuDto> findAll(){
        return handong.values().stream()
                .map(menu -> MenuDto.builder()
                        .studentId(menu.getStudentId())
                        .studentName(menu.getStudentName())
                        .build()).toList();
    }
    public void update(Integer studentId, MenuDto menuDto){
        Menu menu = handong.get(studentId);
        menu.setStudentId(menuDto.getStudentId());
        menu.setStudentName(menu.getStudentName());
       // handong.put(menu.getStudentId(),menu);
    }
    public void delete(Integer studentId){
        handong.remove(studentId);
    }
}
