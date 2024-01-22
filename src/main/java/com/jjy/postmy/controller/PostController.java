package com.jjy.postmy.controller;

import com.jjy.postmy.dto.PostReqDto;
import com.jjy.postmy.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 로그인 후 포스트 페이지 이동
    @GetMapping("/my-posts")
    public ModelAndView myPost(ModelAndView mav) {
        mav.setViewName("/post/my-posts");
        mav.addObject("posts",postService.allPosts());

        return mav;
    }

    // 글 작성하기
    @PostMapping("/insertPost")
    public String insertPost(PostReqDto postReqDto) {
        postService.insertPost(postReqDto);
        return "redirect:/my-posts";
    }

}
