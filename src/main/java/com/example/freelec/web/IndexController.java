package com.example.freelec.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController // 그냥 문자열 자체 리턴
@Controller // 템플릿 경로 리턴 ()
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // src/main/resources/templates/index.mustache 리턴
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}