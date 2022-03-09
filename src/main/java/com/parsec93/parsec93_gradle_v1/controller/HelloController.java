package com.parsec93.parsec93_gradle_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //ResponseBody가 없으면 템플릿을 사용해서 입력.
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //body 부분에 이 내용을 그대로 직접 넣어주겠다는 뜻의 어노테이션
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring!!!!!!"
        // 페이지 소스보기를 할 경우 이 return 페이지의 경우 html없이 딱 저 내용만 나옴.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        //이 방식으로 return 을 하니까 json 형식으로 데이터를 다시 돌려주게 됨.
    }

    static class Hello {
        private String name;//겟터 셋터 생성 단축키(intelliJ) : ctrl + enter

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}