package com.post.project.business.user.api;

import com.post.project.business.user.application.UserService;
import com.post.project.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private static final int USE_EMAIL = 1;

  private final UserService userService;

  @GetMapping("/checkUsername")
  public ResponseEntity<CommonResponse> checkUsername(String username){
    int isUseEmail = userService.findByUsername(username);
    if(USE_EMAIL == isUseEmail){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new CommonResponse<>(HttpStatus.BAD_REQUEST.value(), "이미 사용중인 유저네임입니다.", ""));
    }else{
      return ResponseEntity.status(HttpStatus.OK)
        .body(new CommonResponse<>(HttpStatus.OK.value(), "사용 가능한 유저네임입니다.", ""));
    }
  }

}
