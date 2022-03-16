package com.parsec93.parsec93_gradle_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // /로 맵핑이 된 파일이 있는지 스프링이 먼저 찾아본 다음에 그런 파일이 없으면 index.html(hello.html) 정적 파일을 찾아본다.
        return "home";
    }
}
