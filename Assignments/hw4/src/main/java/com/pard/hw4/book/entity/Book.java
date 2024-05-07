package com.pard.hw4.book.entity;

import com.pard.hw4.book.dto.BookCreateDto;
import com.pard.hw4.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.groups.Default;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ColumnDefault("0")
    private boolean isLoaned;

    //생성자 방식은 새로 만드는 것(create)만 가능하다.
    public Book(BookCreateDto dto, User user){
        this.name = dto.getName();
        this.user = user;
        this.isLoaned=false;
    }
}
