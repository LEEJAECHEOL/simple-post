package com.post.project.common.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * @EntityListeners(AuditingEntityListener.class) => Auditing는 자동으로 값을 넣어줌.
 * @MappedSuperclass => JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 
 *                      createDate, lastModifiedDate를 컬럼으로 인식
 * 
 */

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BasicEntity {
	  @CreatedDate // entity가 생성될 때 시간을 넣어줌
    private LocalDateTime createdDate;
    @LastModifiedDate // entity가 수정될 때 시간을 넣어줌.
    private LocalDateTime updatedDate;
    
    
}
