package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")

public class RestAPIController {
    @GetMapping("{menuNameNameId}")
    public String hi(@PathVariable Integer menuId){
        return "Get으로 온 컨트롤러" + menuId;
    }
    @PostMapping
    public String menuAll(){
        return "Post : menu Create";
    }
    @GetMapping
    public String menuCreate(){
        return "get : menu Read";
    }
    @PutMapping
    public String menuUpdate(){
        return "put : menu update";
    }
    @PatchMapping
    public String menuUpdateByPatch(){
        return "patch : menuUpdateByPatch";
    }
    @DeleteMapping
    public String menuDelete(){
        return "delete : menuDelete";
    }
}

