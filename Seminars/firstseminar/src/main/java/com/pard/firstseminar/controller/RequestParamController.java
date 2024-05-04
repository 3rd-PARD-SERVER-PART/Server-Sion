package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(
            @RequestParam("name") String hiName,
            @RequestParam("age") int hiAge){
                    return "requestParam name" + hiName + "age" + hiAge;
    }
    @RequestMapping("/v2")
    public String requestParamV2(
            @RequestParam String name,
            @RequestParam int age){
        return "requestParamV2 name" + name + "age" + age;
    }
    @RequestMapping("/v3")
    public String requestParamV3(
            String name,
            int age){
        return "requestParamV2 name" + name + "age" + age;
    }
    @RequestMapping("/v4")
    public String requestParamV4(
            @RequestParam String name,
            @RequestParam(required = false) Integer age){
        return "requestParamV2 name" + name + "age" + age;
    }
    @RequestMapping("/v5")
    public String requestParamV5(
            @RequestParam(defaultValue = "guest") String name,
            @RequestParam(defaultValue = "20") Integer age){
        return "requestParamV2 name: " + name + " age: " + age;
    }
    @RequestMapping("/map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap){
        return "requestParamV6 name: " + paramMap.get("name") + " age: " + paramMap.get("age");
    }
}
