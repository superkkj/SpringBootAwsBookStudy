package com.bookStudy.boo.springboot.web;


import com.bookStudy.boo.springboot.service.posts.PostsService;
import com.bookStudy.boo.springboot.web.dto.PostUpdateRequestDto;
import com.bookStudy.boo.springboot.web.dto.PostsResponseDto;
import com.bookStudy.boo.springboot.web.dto.PostsSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestsDto requestsDto) {
        return postsService.save(requestsDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestsDto) {
        return postsService.update(id, requestsDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
