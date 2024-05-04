package com.example.thirdAssignment.menu.controller;

import com.example.thirdAssignment.menu.dto.MenuDto;
import com.example.thirdAssignment.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody MenuDto menuDto) {
        menuService.save(menuDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{menuId}")
    public ResponseEntity<MenuDto> readById(@PathVariable Long menuId) {
        MenuDto menuDto = menuService.read(menuId);
        if (menuDto != null) {
            return new ResponseEntity<>(menuDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<MenuDto>> readAll() {
        List<MenuDto> menuDtos = menuService.readAll();
        return new ResponseEntity<>(menuDtos, HttpStatus.OK);
    }

    @PatchMapping("{menuId}")
    public ResponseEntity<Void> update(@PathVariable Long menuId, @RequestBody MenuDto menuDto) {
        menuService.update(menuId, menuDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{menuId}")
    public ResponseEntity<Void> delete(@PathVariable Long menuId) {
        menuService.delete(menuId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/menuNum")
    public ResponseEntity<Long> readMenuIdByName(@RequestParam String menuName) {
        Long menuId = menuService.getMenuNum(menuName);
        return new ResponseEntity<>(menuId, HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<MenuDto> recommendRandomMenu() {
        MenuDto randomMenuDto = menuService.recommendRandomMenu();
        if (randomMenuDto != null) {
            return new ResponseEntity<>(randomMenuDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/price-less-than")
    public ResponseEntity<List<MenuDto>> findByPriceLessThan(@RequestParam int price) {
        List<MenuDto> menuDtos = menuService.findByPriceLessThan(price);
        return new ResponseEntity<>(menuDtos, HttpStatus.OK);
    }

    @GetMapping("/price-greater-than")
    public ResponseEntity<List<MenuDto>> findByPriceGreaterThan(@RequestParam int price) {
        List<MenuDto> menuDtos = menuService.findByPriceGreaterThan(price);
        return new ResponseEntity<>(menuDtos, HttpStatus.OK);
    }

    @GetMapping("/by-name")
    public ResponseEntity<MenuDto> findByName(@RequestParam String menuName) {
        MenuDto menuDto = menuService.findByName(menuName);
        if (menuDto != null) {
            return new ResponseEntity<>(menuDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
