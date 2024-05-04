package org.example.fourthseminar.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.fourthseminar.book.dto.BookReadDTO;
import org.example.fourthseminar.book.entity.Book;
import org.example.fourthseminar.user.entity.User;

import java.util.List;

public class UserDTO {
    @Getter
    @Setter
    public static class Create {
        private String name;
        private Integer age;
        private String major;
    }
    @Getter
    @Setter
    public static class ReadBook {
        private Long id;
        private String name;
        private Integer age;
        private String major;
    }
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL) // JSON에 포함하는데, null 값이 아닌 것만 포함해라.
    public static class Read {
        private Long id;
        private String name;
        private Integer age;
        private String major;
        private List<BookReadDTO> books;

        public Read(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.age = user.getAge();
            this.major = user.getMajor();
        }

        // 생성자로 만듬
        // 무한 루프 막는 코드
        public Read(User user, List<BookReadDTO> books) {
            this.id = user.getId();
            this.name = user.getName();
            this.age = user.getAge();
            this.major = user.getMajor();
            this.books = books;
        }
    }
}

