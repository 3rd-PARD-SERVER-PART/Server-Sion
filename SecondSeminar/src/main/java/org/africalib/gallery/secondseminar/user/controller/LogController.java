package org.africalib.gallery.secondseminar.menu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public String log() {
        String name = "SPRING";

        log.info("name : {}", name);
        log.warn("name : {}", name);
        log.error("name : {}", name);
        log.debug("name : {}", name);
        log.trace("name : {}", name); //잘 사용하지 않음 -> 메모리 사용하여 연산해서 성능에 문제가 생길 수 있음

        return "Hello, " + name;
    }
}
