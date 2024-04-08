package com.example.thirdAssignment.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;
    
    @Column(name = "menuName")
    private String menuName;

    @Column(name = "menuPrice")
    private String menuPrice;
    
    
    @CreationTimestamp
    private Timestamp menuSignupTime;


}
