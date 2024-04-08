package org.africalib.gallery.secondseminar.menu.service;

import lombok.RequiredArgsConstructor;
import org.africalib.gallery.secondseminar.menu.dto.MenuDto;
import org.africalib.gallery.secondseminar.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    public void saveMenu(MenuDto menuDto){
        menuRepository.save(menuDto);
    }
    public MenuDto findById(Integer studentId){
        return menuRepository.findById(studentId);
    }
    public List<MenuDto> findAll(){
        return menuRepository.findAll();
    }
    public void update(Integer studentId, MenuDto menuDto){
        menuRepository.update(studentId, menuDto);
    }
    public void delete(Integer studentId){
        menuRepository.delete(studentId);
    }
}
