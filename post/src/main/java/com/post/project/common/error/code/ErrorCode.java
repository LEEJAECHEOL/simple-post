package com.post.project.common.error.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
	// Post
	NOT_FOUND_POST(400, "P004001", "해당 포스트를 찾을 수 없습니다.");
	
    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}