package com.bookStudy.boo.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //모든 필드의 get method 생성
@RequiredArgsConstructor //final fiedl 만 생성자 생성.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
