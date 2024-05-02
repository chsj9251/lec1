package com.chae.book.springboot.web;

import com.chae.book.springboot.config.auth.dto.SessionUser;
import com.chae.book.springboot.services.PostsService;
import com.chae.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/") // 조회기능
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
        //머스테치 스타터 덕분에 .mastache 확장자를 붙이지 않아도 자동으로 붙여준다.
    }

    @GetMapping("/posts/save") // 등록기능
    public String postsSave() {return "posts-save";}

    @GetMapping("/posts/update/{id}") // 수정기능
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
