package com.example.thirdAssignment.menu.controller;

import com.example.thirdAssignment.menu.dto.MenuDto;
import com.example.thirdAssignment.menu.entity.Menu;
import com.example.thirdAssignment.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private  final MenuService menuService;
    @PostMapping("")
    public void save(@RequestBody MenuDto menuDto){
        menuService.save(menuDto);
    }

    @GetMapping("{menuId}")
    public MenuDto readById(@PathVariable Long menuId){
        return menuService.read(menuId);
    }

    @GetMapping("")
    public List<MenuDto> readAll(){
        return menuService.readAll();
    }
    @PatchMapping("{menuId}")
    public void update(@PathVariable Long menuId,
                       @RequestBody MenuDto menuDto){
        menuService.update(menuId, menuDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long menuId){
        menuService.delete(menuId);
    }
    @GetMapping("/menuNum")
    public ResponseEntity<Long> read(@RequestParam String menuName){
        Long returnToClient = menuService.getMenuNum(menuName);
        return new ResponseEntity<>(returnToClient, HttpStatus.OK);
    }

}
