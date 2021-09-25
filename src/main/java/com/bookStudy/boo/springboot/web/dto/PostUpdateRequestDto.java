package com.bookStudy.boo.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;


    @Builder
    public PostUpdateRequestDto(String tilte, String content) {
        this.title = tilte;
        this.content = content;
    }
}
