package com.bookStudy.boo.springboot.service.posts;

import com.bookStudy.boo.springboot.domain.posts.Posts;
import com.bookStudy.boo.springboot.domain.posts.PostsRepository;
import com.bookStudy.boo.springboot.web.dto.PostUpdateRequestDto;
import com.bookStudy.boo.springboot.web.dto.PostsSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto) {
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long  update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없어요!id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsSaveRequestsDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없어요! id=" + id));

        return new PostsSaveRequestsDto(entity);

    }
}
