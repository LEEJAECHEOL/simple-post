package com.post.project.common.error.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.post.project.common.error.code.ErrorCode;
import com.post.project.common.error.exception.BusinessException;
import com.post.project.common.error.response.ErrorResponse;
import com.post.project.common.response.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> businessException(BusinessException e) {
		ErrorCode errorCode = e.getErrorCode();
		ErrorResponse errorResponse = new ErrorResponse(errorCode);
		errorResponse.setMessage(errorCode.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getStatus()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> dataIntegrityViolationException(DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new CommonResponse<>(HttpStatus.BAD_REQUEST.value(), "이미 사용중인 유저네임입니다.", ""));
	}
}
