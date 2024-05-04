package org.africalib.gallery.secondseminar.menu.controller;

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
    @GetMapping("/{studentId}")
    public MenuDto findById(@PathVariable Integer studentId){
        return menuService.findById(studentId);
    }
    @GetMapping("")
    public List<MenuDto> findAll(){
        return menuService.findAll();
    }
    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer studentId,@RequestBody MenuDto menuDto){
        menuService.update(studentId,menuDto);
    }
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId,@RequestBody MenuDto menuDto){
        menuService.delete(studentId);
    }
}
