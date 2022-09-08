package com.linwu.vue3.api.extend.ex;

import com.linwu.vue3.api.enums.IRespCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
  private String bizMsg;
  private String bizCode;
  private IRespCode errorCode;

  public BizException() {
    super();
  }


}
