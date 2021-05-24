package com.post.project.business.auth.form;

import com.post.project.business.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

public class AuthForm {

  public static class Request{
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Join{
      @NotBlank(message = "유저네임을 입력해주세요.")
      private String username;
      @NotBlank(message = "비밀번호를 입력해주세요.")
      private String password;

      private String email;

      public User toEntity(){
        return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
      }

    }
  }

  public static class Response{

  }
}
