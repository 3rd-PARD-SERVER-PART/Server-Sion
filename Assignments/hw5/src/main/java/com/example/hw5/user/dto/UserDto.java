package com.example.hw5.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.hw5.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class UserDto {
    @Setter
    @Getter
    public static class Create{
        private String name;
        private String email;
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private String email;

        private List<UserLoanDto.Read> history;

        public Read(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
        }
    }
}
