package com.example.freelec.web;

import com.example.freelec.config.auth.LoginUser;
import com.example.freelec.config.auth.dto.SessionUser;
import com.example.freelec.service.posts.PostsService;
import com.example.freelec.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

// @RestController // 그냥 문자열 자체 리턴
@Controller // 템플릿 경로 리턴 ()
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    /*@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAlLDesc());
        // 로그인 성공 시 세션에 SessionUser 저장
        // 즉 로그인 성공 시 값 가져올 수 있음
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("usernName", user.getName());
        }
        return "index"; // src/main/resources/templates/index.mustache 리턴
    }*/

    // 직접 만든 @LoginUser 어노테이션 사용
    @GetMapping("/")
    // 기존 가져오던 세션 정보 값이 개선됨.
    // 이제 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보 가져올 수 있음.
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAlLDesc());
        if (user != null) {
            model.addAttribute("usernName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    // 수정 화면
    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}