package com.post.project.business.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public int findByUsername(String username){
    return userRepository.findByUsername(username);
  }

}
