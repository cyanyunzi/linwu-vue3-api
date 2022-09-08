package com.linwu.vue3.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linwu.vue3.api.mapper.DictMapper;
import com.linwu.vue3.api.model.base.BasePageListResp;
import com.linwu.vue3.api.model.entity.Dict;
import com.linwu.vue3.api.model.req.DictPageReq;
import com.linwu.vue3.api.model.resp.DictPageResp;
import com.linwu.vue3.api.utils.QueryWrapperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author linwu
 * @since 2022-08-31
 */
@Service
public class DictService extends ServiceImpl<DictMapper, Dict> {

    public BasePageListResp<DictPageResp> selectPages(DictPageReq req) {
        QueryWrapper<Dict> wrapper = QueryWrapperUtil.create(Dict.class);
        QueryWrapperUtil.notBlankLike(wrapper, Dict.NAME, req.getName());
        QueryWrapperUtil.notBlankEq(wrapper, Dict.CODE, req.getCode());
        QueryWrapperUtil.notBlankEq(wrapper, Dict.TYPE, req.getType());
        QueryWrapperUtil.notNullEq(wrapper, Dict.PARENT_ID, req.getParentId());

        Page<Dict> page = page(new Page<>(req.getPage(), req.getSize()), wrapper);
        return  BasePageListResp.convert(page, (Dict entity) -> {
            DictPageResp dictResp = new DictPageResp();
            BeanUtils.copyProperties(entity, dictResp);
            return dictResp;
        });
    }
}
