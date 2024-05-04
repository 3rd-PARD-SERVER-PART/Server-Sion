package org.example.fourthseminar.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.fourthseminar.user.dto.UserDTO;
import org.example.fourthseminar.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    @Operation(summary = "유저 등록", description = "유저를 이름과 전공과 나이를 통해 생성합니다.")
    public String createUser(@RequestBody UserDTO.Create dto) {
        userService.createUser(dto);
        return "유저 추가됨";
    }

    @GetMapping("")
    public List<UserDTO.Read> readAll() {
        return userService.readAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
