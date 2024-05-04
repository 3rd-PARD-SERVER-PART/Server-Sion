package org.example.fourthseminar.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.fourthseminar.book.entity.Book;
import org.example.fourthseminar.user.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String major;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    //, cascade = CascadeType.ALL,
    // orphanRemoval = true -> 주인과 노예가 DB 상에서 같이 삭제될 수 있도록
    // 예를 들어,
    /*
    무신사를 카카오톡으로 로그인을 했다.
    그리고 무신사 계정을 지우려고 한다 (이 개념이 맞나?)
    하지만 카카오톡이 연결되었다고 해서 카카오톡 자체가 삭제되면 안되기 때문에,
    work table(중간 관리자)에서 history를 저장?하고
    무신사와 카카오톡(master table) 간의 연결을 끊어준다.
     */
    private List<Book> books = new ArrayList<>();


    // builder 코드
    // Entity를 사용해야 하기 때문에,
    // dto를 entity로 변환해야 한다.
    public static User toEntity(UserDTO.Create dto) {
        return User.builder()
                .name(dto.getName())    // dto에서 받아온 name을 사용할거야.
                .age(dto.getAge())      // dto에서 받아온 age를 사용할거야.
                .major(dto.getMajor())  // dto에서 받아온 major을 사용할거야.
                .build();
    }
}
