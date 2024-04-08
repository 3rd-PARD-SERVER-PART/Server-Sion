package com.example.thirdAssignment.menu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.thirdAssignment.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    public Menu findByMenuMenuName(String menuMenuName);
}
