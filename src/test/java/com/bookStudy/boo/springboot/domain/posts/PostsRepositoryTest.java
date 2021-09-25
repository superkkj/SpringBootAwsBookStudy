package com.bookStudy.boo.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 자동으로 실행해준당
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After //단위 테스트 끝날때 작동 데이터 침범을 막기위해 .
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        String title = "게시글 제목";
        String content = "게시글 본문";

        postsRepository.save(Posts.builder() //save 기능은 insert/update  id가 잇으면 업데이트를 실행한다.
                .title(title)
                .content(content)
                .author("kkkj@naver.com")
                .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void 베이스엔티티_등록() {

        //given
        LocalDateTime now = LocalDateTime.of(2021, 9, 25, 0, 0, 0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());


        //when
        List<Posts> postsList = postsRepository.findAll();


        //then

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate=" + posts.getCreatedDate() );
        System.out.println(">>>>>>>>>> modifyDate=" + posts.getModifiedDate() );

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
