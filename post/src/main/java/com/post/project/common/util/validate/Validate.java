package com.post.project.common.util.validate;

import com.post.project.common.error.code.ErrorCode;
import com.post.project.common.error.exception.BusinessException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
  private final static String REGEX_EMAIL = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

  public static void checkEmail(String email){

    if(!"".equals(email) && email != null){
      Pattern p = Pattern.compile(REGEX_EMAIL);
      Matcher m = p.matcher(email);
      if(!m.matches()) {
        throw new BusinessException(ErrorCode.INVALID_EMAIL_FORMAT);
      }
    }
  }

}
