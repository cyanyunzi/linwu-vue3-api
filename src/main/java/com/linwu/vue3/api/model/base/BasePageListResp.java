package com.linwu.vue3.api.model.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class BasePageListResp<T> extends BaseMode {
    private Integer page;
    private Integer size;
    private Integer total;
    private Integer pages;
    private List<T> list = Lists.newArrayList();

    public static <E extends BaseEntity, R extends BaseResp> BasePageListResp<R> convert(Page<E> page, Function<E, R> function) {
        BasePageListResp result = new BasePageListResp();
        result.setPage((int) page.getCurrent());
        result.setSize((int) page.getSize());
        result.setTotal((int) page.getTotal());
        result.setPages((int) page.getPages());
        List<R> list = page.getRecords().stream().map(entity -> function.apply(entity)).collect(Collectors.toList());

        result.setList(list);
        return result;
    }

    public static <E extends BaseEntity, R extends BaseResp> BasePageListResp<R> build(Page<E> page) {
        BasePageListResp result = new BasePageListResp();
        result.setPage((int) page.getCurrent());
        result.setSize((int) page.getSize());
        result.setTotal((int) page.getTotal());
        result.setPages((int) page.getPages());
        result.setList(page.getRecords());
        return result;
    }


}
