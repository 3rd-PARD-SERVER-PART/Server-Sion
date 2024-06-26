package com.pard.hw4.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.dto.BookReadDto;
import com.pard.hw4.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


public class UserDto {
    @Setter
    @Getter
    public static class Create{
        private String name;
        private Integer age;
        private String major;
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private Integer age;
        private String major;
        private List<UserLoanDto.Read> history;

        public Read(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.age = user.getAge();
            this.major = user.getMajor();
        }
    }
}
