package com.post.project.business.post.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.project.business.post.application.PostService;
import com.post.project.business.post.entity.Post;
import com.post.project.business.post.form.PostForm.*;
import com.post.project.common.response.CommonResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PostController {
	
	private final PostService postService;
	
	@GetMapping("/post")
	public ResponseEntity<CommonResponse> findAll(){
		List<Post> postEntity = postService.findAll();
		log.info("Post 전체 가져오기");
		
		return ResponseEntity.status(HttpStatus.OK)
							.body(new CommonResponse<List<Post>>(HttpStatus.OK.value(), postEntity));
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<CommonResponse> findById(@PathVariable Long id){
		Post postEntity = postService.findById(id);
		log.info("Post id : " + id + " 가져오기");
		return ResponseEntity.status(HttpStatus.OK)
							.body(new CommonResponse<Post>(HttpStatus.OK.value(), postEntity));
	}
	
	@PostMapping("/post")
	public ResponseEntity<CommonResponse> save(@Valid @RequestBody Request.Save save) {
		Post postEntity = postService.save(save.toEntity());
		log.info("Post id : " + postEntity.getId() + " 저장");
		return ResponseEntity.status(HttpStatus.CREATED)
							.body(new CommonResponse<Post>(HttpStatus.CREATED.value(), postEntity));
	}
	
	@PutMapping("/post/{id}")
	public ResponseEntity<CommonResponse> updateById(@PathVariable Long id, @RequestBody Request.Update update){
		Post postEntity = postService.updateById(id, update.toEntity());
		log.info("Post id : " + postEntity.getId() + " 수정");
		return ResponseEntity.status(HttpStatus.OK)
							.body(new CommonResponse<Post>(HttpStatus.OK.value(), postEntity));
	}
	

}
