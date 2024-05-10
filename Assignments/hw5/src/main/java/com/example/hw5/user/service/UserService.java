package com.example.hw5.user.service;

import com.example.hw5.user.dto.UserDto;
import com.example.hw5.user.entity.User;
import com.example.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserDto.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public List<UserDto.Read> readAll(){

        return userRepo.findAll()
                .stream()
                .map(user -> new UserDto.Read(user))
                .collect(Collectors.toList());
    }

}
