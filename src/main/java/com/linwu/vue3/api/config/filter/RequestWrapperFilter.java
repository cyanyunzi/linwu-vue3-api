package com.linwu.vue3.api.config.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：林雾
 * @date ：2020/05/06
 * @description :
 */
@Component
public class RequestWrapperFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain)
      throws ServletException, IOException {
    filterChain.doFilter(new ContentCachingRequestWrapper(httpServletRequest), httpServletResponse);
  }
}
