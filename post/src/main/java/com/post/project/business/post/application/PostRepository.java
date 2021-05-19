package com.post.project.business.post.application;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.project.business.post.entity.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
