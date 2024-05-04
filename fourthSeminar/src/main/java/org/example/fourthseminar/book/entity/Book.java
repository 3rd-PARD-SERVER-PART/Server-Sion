package org.example.fourthseminar.book.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.fourthseminar.book.dto.BookCreateDTO;
import org.example.fourthseminar.user.entity.User;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
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


    public Book(BookCreateDTO dto, User user) {
        // User에서는 book을 건들지 않지만, book에서는 user를 건들 수 있따.
        this.name = dto.getName();
        this.user = user; // '다:1'에선 다가 주인이니까 여기서 user를 건든다.
    }

    // 위의 코드와 같음 (?)
//    public static Book toEntity(BookCreateDTO dto, User user){
//        return Book.builder()
//                .name(dto.getName())
//                .user(user)
//                .build();
//    }

    public void update(BookCreateDTO dto, User user) {
        this.name = dto.getName();
        this.user = user;
    }


}
