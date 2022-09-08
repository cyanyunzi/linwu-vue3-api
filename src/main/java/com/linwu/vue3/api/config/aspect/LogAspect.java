package com.linwu.vue3.api.config.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linwu.vue3.api.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Qualifier("myObjectMapper")
    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("execution(public * com.linwu.vue3.api.controller..*.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = RequestUtils.getRequest();
        ContentCachingRequestWrapper wrapper =
                WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        Map<String, Object> map = WebUtils.getParametersStartingWith(wrapper, "");
        String json = new String(wrapper.getContentAsByteArray());
        Object result = joinPoint.proceed(joinPoint.getArgs());

        log.info(
                "url:[{}] method:[{}] parameter:[{}] json:[{}] response:[{}]",
                request.getRequestURL(),
                request.getMethod(),
                map,
                json,
                objectMapper.writeValueAsString(result));

        return result;
    }
}
