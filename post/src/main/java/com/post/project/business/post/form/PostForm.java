package com.post.project.business.post.form;

import javax.validation.constraints.NotBlank;

import com.post.project.business.post.entity.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class PostForm {
	
	public static class Request{
		@Getter
		@Setter
		@NoArgsConstructor
		public static class Save{
			@NotBlank(message = "제목을 입력해주세요.")
			private String title;
			@NotBlank(message = "내을 입력해주세요.")
			private String content;
			
			public Post toEntity() {
				return Post.builder()
							.title(title)
							.content(content)
							.build();
			}
		}
		@Getter
		@Setter
		@NoArgsConstructor
		public static class Update{
			@NotBlank(message = "제목을 입력해주세요.")
			private String title;
			@NotBlank(message = "내을 입력해주세요.")
			private String content;
			
			public Post toEntity() {
				return Post.builder()
							.title(title)
							.content(content)
							.build();
			}
		}
	}

	public static class Response{
		
	}
}
