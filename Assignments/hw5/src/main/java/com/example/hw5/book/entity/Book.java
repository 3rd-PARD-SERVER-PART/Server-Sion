package com.example.hw5.book.entity;

import com.example.hw5.book.dto.BookCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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




    @ColumnDefault("0")
    private boolean isLoaned;

    public static Book toEntity(BookCreateDto dto){
        return Book.builder()
                .name(dto.getName())
                .build();
    }
    public void change(boolean loaned){
        this.isLoaned = loaned;
    }
}
