package com.post.project.business.auth.api;

import com.post.project.business.auth.application.AuthService;
import com.post.project.business.auth.form.AuthForm;
import com.post.project.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/join")
  public ResponseEntity<CommonResponse> join(@Valid @RequestBody AuthForm.Request.Join join){
    authService.join(join.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(new CommonResponse<>(HttpStatus.CREATED.value(), "회원가입을 성공하였습니다.", ""));
  }

}
