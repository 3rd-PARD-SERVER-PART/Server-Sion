package com.example.thirdAssignment.menu.dto;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MenuDto { //create, read, update, delete를 위한 DTO
    private String menuName;
    private String menuPrice;
}
