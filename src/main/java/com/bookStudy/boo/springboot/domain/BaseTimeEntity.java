package com.bookStudy.boo.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 캘래스들이 베이스타임엔티티를 상속할경우 필드들도 칼럼으로 인식하게함
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 포함시키기
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate; // 엔티티생성시 시간 자동저장

    @LastModifiedDate // 엔티티 변경시 자동저장
    private LocalDateTime modifiedDate;
}
