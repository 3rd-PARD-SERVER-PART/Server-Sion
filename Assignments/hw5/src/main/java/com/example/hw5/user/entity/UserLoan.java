package com.example.hw5.user.entity;

import com.example.hw5.book.entity.Book;
import com.example.hw5.user.dto.UserLoanDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false ,name = "book_id")
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

    public static UserLoan toEntity(UserLoanDto.Create dto, User user, Book book){
        return UserLoan.builder()
                .user(user)
                .book(book)
                .build();
    }
    public void change(boolean returned){
        this.isReturn = returned;
    }

}
