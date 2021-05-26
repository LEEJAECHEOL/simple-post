package com.post.project.business.post.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.post.project.business.post.entity.Post;
import com.post.project.common.error.code.ErrorCode;
import com.post.project.common.error.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	@Transactional(readOnly = true)
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Post findById(Long id) {
		return postRepository.findById(id)
							.orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));
	}
	
	@Transactional
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	@Transactional
	public Post updateById(Long id, Post post) {
		Post postEntity = postRepository.findById(id)
							.orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));
		postEntity.updatePost(post.getTitle(), post.getContent());
		return postEntity;
	}
	
}
