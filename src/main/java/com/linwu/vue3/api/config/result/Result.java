package com.linwu.vue3.api.config.result;

import com.linwu.vue3.api.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
  private String respCode;
  private String respMsg;
  private String bizCode;
  private String bizMsg;
  private T data;

  public Result() {}

  public static Result ok() {
    Result result = new Result();
    result.setRespCode(ResponseEnum.SUCCESS.getCode());
    result.setRespMsg(ResponseEnum.SUCCESS.getMsg());
    return result;
  }

  public static<T> Result ok(T t) {
    Result result = new Result();
    result.setRespCode(ResponseEnum.SUCCESS.getCode());
    result.setRespMsg(ResponseEnum.SUCCESS.getMsg());
    result.setData(t);
    return result;
  }

  public static Result bizFail() {
    Result result = new Result();
    result.setRespCode(ResponseEnum.BIZ_ERROR.getCode());
    result.setRespMsg(ResponseEnum.BIZ_ERROR.getMsg());
    return result;
  }

  public static Result error() {
    Result result = new Result();
    result.setRespCode(ResponseEnum.ERROR.getCode());
    result.setRespMsg(ResponseEnum.ERROR.getMsg());
    return result;
  }

  public static Result paramFail() {
    Result result = new Result();
    result.setRespCode(ResponseEnum.PARAM_ERROR.getCode());
    result.setRespMsg(ResponseEnum.PARAM_ERROR.getMsg());
    return result;
  }
}
