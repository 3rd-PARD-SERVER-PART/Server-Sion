package org.africalib.gallery.secondassignment.menu.controller;

import lombok.RequiredArgsConstructor;
import org.africalib.gallery.secondseminar.menu.dto.MenuDto;
import org.africalib.gallery.secondseminar.menu.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    @PostMapping("")
    public void saveMenu(@RequestBody MenuDto menuDto){
        menuService.saveMenu(menuDto);
    }
    @GetMapping("/{id}")
    public MenuDto findById(@PathVariable Integer id){
        return menuService.findById(id);
    }
    @GetMapping("")
    public List<MenuDto> findAll(){
        return menuService.findAll();
    }
    @PatchMapping("/{id}")
    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody MenuDto menuDto){
        menuService.update(id, menuDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        menuService.delete(id);
    }
}
