package com.post.project.common.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonResponse<T> {
	private int status;
	private String message;
	private T data;
	
	public CommonResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public CommonResponse(int status, T data){
		this.status = status;
		this.data = data;
	}
	
	public CommonResponse(int status, String message, T data){
		this.status = status;
		this.message = message;
		this.data = data;
	}
}
