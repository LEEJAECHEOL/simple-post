package com.post.project.business.auth.application;

import com.post.project.business.user.application.UserRepository;
import com.post.project.business.user.entity.User;
import com.post.project.common.util.validate.Validate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;

  @Transactional
  public void join(User user){
    Validate.checkEmail(user.getEmail());
    userRepository.save(user);
  }
}
