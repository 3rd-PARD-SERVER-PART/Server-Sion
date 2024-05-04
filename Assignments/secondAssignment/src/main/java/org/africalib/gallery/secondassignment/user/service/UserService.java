package org.africalib.gallery.secondassignment.menu.service;

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
    public MenuDto findById(Integer id){
        return menuRepository.findById(id);
    }
    public List<MenuDto> findAll(){
        return menuRepository.findAll();
    }
    public void update(Integer id, MenuDto menuDto){
        menuRepository.update(id, menuDto);
    }
    public void delete(Integer id){
        menuRepository.delete(id);
    }
}
