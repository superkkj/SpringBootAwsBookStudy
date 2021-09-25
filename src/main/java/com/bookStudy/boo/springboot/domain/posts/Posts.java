package com.bookStudy.boo.springboot.domain.posts;

import com.bookStudy.boo.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동추가 . public Posts(){}
@Entity // 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {

    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;


    @Column(length = 500, nullable = false) //굳이 선언하지않더라도 모두 칼럼이된다 나머지 필드는. 사용할경우 옵션을 주기위해
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //실제 DB 테이블과 매칭될 클래스이며 보통 Entity 라고도 한다.  JPA 사용시 데이터 작업할경우 실제쿼리보다 이 클래스 수정  통해작업?
    // 해당 클래스의 빌더 패턴 클래스 생성?  생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
