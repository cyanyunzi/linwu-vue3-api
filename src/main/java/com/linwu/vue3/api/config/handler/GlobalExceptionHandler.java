package com.linwu.vue3.api.config.handler;

import com.linwu.vue3.api.config.result.Result;
import com.linwu.vue3.api.enums.IRespCode;
import com.linwu.vue3.api.extend.ex.BizException;
import com.linwu.vue3.api.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /** 处理所有不可知的异常 */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Result exception(Exception ex) {
    HttpServletRequest request = RequestUtils.getRequest();
    Result result = Result.error();
    result.setBizMsg(ex.getMessage());

    String url = request.getRequestURL().toString();
    String method = request.getMethod();

    ContentCachingRequestWrapper wrapper =
        WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
    Map<String, Object> map = WebUtils.getParametersStartingWith(wrapper, "");
    String json = new String(wrapper.getContentAsByteArray());

    log.error(
        "*****系统异常***** url:[{}] method:[{}] parameter:[{}] json:[{}] msg:[{}] ex:[{}]",
        url,
        method,
        map,
        json,
        ex.getMessage(),
        ex);

    return result;
  }

  @ExceptionHandler(BizException.class)
  @ResponseBody
  public Result exception(BizException ex) {
    HttpServletRequest request = RequestUtils.getRequest();

    Result result = Result.bizFail();

    IRespCode errorCode = ex.getErrorCode();

    if (errorCode != null) {
      result.setBizCode(errorCode.getCode());
      result.setBizMsg(errorCode.getMsg());
    } else {
      result.setBizMsg(ex.getBizMsg());
    }

    String url = request.getRequestURL().toString();
    String method = request.getMethod();
    ContentCachingRequestWrapper wrapper =
        WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
    Map<String, Object> map = WebUtils.getParametersStartingWith(wrapper, "");
    String json = new String(wrapper.getContentAsByteArray());

    log.warn(
        "*****业务异常***** url:[{}] method:[{}] parameter:[{}] json:[{}] msg:[{}]",
        url,
        method,
        map,
        json,
        ex.getMessage());
    return result;
  }

  @ExceptionHandler(BindException.class)
  @ResponseBody
  public Result validatedBindException(BindException ex) {
    Optional<ObjectError> first = ex.getBindingResult().getAllErrors().stream().findFirst();
    String message = first.map(error -> error.getDefaultMessage()).orElse("参数校验异常");

    HttpServletRequest request = RequestUtils.getRequest();
    log.warn("*****校验异常***** Url:[{}] message: [{}]", request.getRequestURL(), message);
    Result result = Result.bizFail();
    result.setRespMsg(message);
    return result;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Result validatedBindException(MethodArgumentNotValidException ex) {
    Optional<ObjectError> first = ex.getBindingResult().getAllErrors().stream().findFirst();
    String message = first.map(error -> error.getDefaultMessage()).orElse("参数校验异常");

    HttpServletRequest request = RequestUtils.getRequest();
    log.warn("*****校验异常***** Url:[{}]  message: [{}]", request.getRequestURL(), message);
    Result result = Result.paramFail();
    result.setRespMsg(message);
    return result;
  }
}
