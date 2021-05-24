package com.post.project.common.error.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
	// Post
	NOT_FOUND_POST(400, "P004001", "해당 포스트를 찾을 수 없습니다."),

  // Auth
  INVALID_EMAIL_FORMAT(400, "A004001", "올바른 이메일 형식이 아닙니다.")

  ;
	
    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
