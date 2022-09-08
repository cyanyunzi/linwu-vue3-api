package com.linwu.vue3.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Test1Enum implements IEnum {
  SUCCESS("0000", "成功"),
  ERROR("9999", "系统错误"),

  BIZ_ERROR("0003", "业务错误"),
  PARAM_ERROR("0004", "参数错误"),
  ;

  private String code;
  private String msg;

}
