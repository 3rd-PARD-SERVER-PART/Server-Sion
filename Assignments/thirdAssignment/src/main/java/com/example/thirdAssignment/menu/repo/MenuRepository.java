package com.example.thirdAssignment.menu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.thirdAssignment.menu.entity.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByMenuName(String menuName);

    List<Menu> findByMenuPriceLessThan(int price);

    List<Menu> findByMenuPriceGreaterThan(int price);
}
