package org.africalib.gallery.secondseminar.user.controller;

import lombok.RequiredArgsConstructor;
import org.africalib.gallery.secondseminar.user.dto.UserDto;
import org.africalib.gallery.secondseminar.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("")
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }
    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Integer studentId){
        return userService.findById(studentId);
    }
    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer studentId,@RequestBody UserDto userDto){
        userService.update(studentId,userDto);
    }
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId,@RequestBody UserDto userDto){
        userService.delete(studentId);
    }
}
