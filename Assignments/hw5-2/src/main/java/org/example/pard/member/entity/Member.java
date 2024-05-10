package org.example.pard.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    // ID 값 자동 생성 IDENTITY로 지정하여 데이터베이스가 자동으로 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // ID 값으로 지정
    private Long id;

    private String name; // 이름

    private String part; // 파트

    private int age; // 나이

    //dto로부터 받은 정보를 Member Entity로 변환 빌더 패턴으로 member Entity 생성
    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
