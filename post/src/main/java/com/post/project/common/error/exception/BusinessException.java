package com.post.project.common.error.exception;

import com.post.project.common.error.code.ErrorCode;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
	private ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
