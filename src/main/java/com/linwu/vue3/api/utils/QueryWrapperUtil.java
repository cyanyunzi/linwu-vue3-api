package com.linwu.vue3.api.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class QueryWrapperUtil {
  public static void notNullEq(QueryWrapper wrapper, String column, Object params) {
    if (params != null) {
      wrapper.eq(column, params);
    }
  }

  public static void notBlankEq(QueryWrapper wrapper, String column, String params) {
    if (StringUtils.isNotBlank(params)) {
      wrapper.eq(column, params);
    }
  }

  public static void notBlankLike(QueryWrapper wrapper, String column, String params) {
    if (StringUtils.isNotBlank(params)) {
      wrapper.like(column, params);
    }
  }

  public static void notEmptyIn(QueryWrapper wrapper, String column, Collection val) {
    if (!CollectionUtils.isEmpty(val)) {
      wrapper.in(column, val);
    }
  }

  public static void limit(QueryWrapper wrapper, Integer limit) {
    if (limit != null) {
      wrapper.last(" limit " + limit);
    }
  }

  public static <T> QueryWrapper<T> create(Class<T> clazz) {
    return new QueryWrapper<>();
  }
}
