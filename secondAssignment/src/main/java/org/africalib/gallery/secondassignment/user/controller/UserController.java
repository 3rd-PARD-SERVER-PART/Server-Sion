package org.africalib.gallery.secondassignment.user.controller;

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
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @PatchMapping("/{id}")
    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserDto userDto){
        userService.update(id, userDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}
