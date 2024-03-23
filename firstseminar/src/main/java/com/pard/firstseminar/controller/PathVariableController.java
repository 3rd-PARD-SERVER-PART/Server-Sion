package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PathVariableController {
    @RequestMapping("/path/{name}")
    public String pathVariable(@PathVariable("name")String userName){
        return "PathVar 연습 name:"+userName;
    }
    @RequestMapping("/pathV2/{name}")
    public String pathVariableV2(@PathVariable String  name){
        return "PathVarV2 연습 name:"+ name;
    }
    @RequestMapping("/pathV3/{name}/{age}")
    public String pathVariableV3(@PathVariable String  name, @PathVariable int age){
        return "PathVarV3 연습 name:"+ name +" age : " +age;
    }
}
