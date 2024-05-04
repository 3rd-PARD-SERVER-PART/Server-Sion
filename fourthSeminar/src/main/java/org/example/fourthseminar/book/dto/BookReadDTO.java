package org.example.fourthseminar.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.fourthseminar.book.entity.Book;
import org.example.fourthseminar.user.dto.UserDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReadDTO {
    private Long bookId;
    private String name;
    // 유저의 값을 넣을건데 바로 유저를 넣지 않고 UserDTO
    private UserDTO.Read user; // UserDTO 안의 Read에서 가져올 수 있어서 더 간편함

    public BookReadDTO(Book book) {
        this.bookId = book.getBookId();
        this.name = book.getName();
    }

    public BookReadDTO(Book book, UserDTO.Read user) {
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.user = user;
    }
}
