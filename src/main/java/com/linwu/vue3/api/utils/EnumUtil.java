package com.linwu.vue3.api.utils;

import com.linwu.vue3.api.enums.IEnum;
import com.linwu.vue3.api.enums.Test1Enum;

public class EnumUtil {

  public static <C, M, T extends IEnum> C matchCodeByMsg(Class<T> clazz, M msg) {
    T[] enumConstants = clazz.getEnumConstants();
    for (T enumConstant : enumConstants) {
      if (msg.equals(enumConstant.getMsg())) {
        return (C) enumConstant.getCode();
      }
    }
    return null;
  }

  public static <C, M, T extends IEnum> M matchMsgByCode(Class<T> clazz, C code) {
    T[] enumConstants = clazz.getEnumConstants();
    for (T enumConstant : enumConstants) {
      if (code.equals(enumConstant.getCode())) {
        return (M) enumConstant.getMsg();
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Object obj1 = EnumUtil.matchCodeByMsg(Test1Enum.class, "系统错误");
    System.out.println(obj1);

    Object obj2 = EnumUtil.matchMsgByCode(Test1Enum.class, "0004");
    System.out.println(obj2);


  }
}
