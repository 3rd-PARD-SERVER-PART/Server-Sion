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
    
    @Column(name = "menuName") //DB컬럼 이름 지정 굳이 필요하지 않음
    private String menuName;

    @Column(name = "menuPrice")
    private int menuPrice;
    
    
    @CreationTimestamp //자동으로 현재 시간이 입력됨
    private Timestamp menuSignupTime;


}
