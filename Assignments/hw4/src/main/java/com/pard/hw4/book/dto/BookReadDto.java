package com.pard.hw4.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReadDto {
    private Long bookId;
    private String name;
    private boolean isLoaned;
    //user 값을 넣기 위해 userDto를 가져옴.
    private UserDto.Read user;
    public BookReadDto(Book book){
        this.bookId = book.getBookId();
        this.name = book.getName();
    }

    public BookReadDto(Book book, UserDto.Read user){
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.isLoaned=book.isLoaned();
        this.user = user;
    }
}
