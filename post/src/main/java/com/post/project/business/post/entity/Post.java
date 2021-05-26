package com.post.project.business.post.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.post.project.common.entity.BasicEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    
    @Builder
    private Post(Long id, String title, String content) {
    	this.id = id;
    	this.title = title;
    	this.content = content;
    }

    public void updatePost(String title, String content){
      this.title = title;
      this.content = content;
    }
}
