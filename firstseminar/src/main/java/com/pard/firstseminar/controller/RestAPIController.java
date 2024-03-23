package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class RestAPIController {
    @GetMapping("{userId}")
    public String hi(@PathVariable Integer userId){
        return "Get으로 온 컨트롤러" + userId;
    }
    @PostMapping
    public String userAll(){
        return "Post : user Create";
    }
    @GetMapping
    public String userCreate(){
        return "get : user Read";
    }
    @PutMapping
    public String userUpdate(){
        return "put : user update";
    }
    @PatchMapping
    public String userUpdateByPatch(){
        return "patch : userUpdateByPatch";
    }
    @DeleteMapping
    public String userDelete(){
        return "delete : userDelete";
    }
}

