package com.linwu.vue3.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.linwu.vue3.api.dao.MenuDao;
import com.linwu.vue3.api.model.base.BasePageListResp;
import com.linwu.vue3.api.model.entity.Dict;
import com.linwu.vue3.api.model.entity.Menu;
import com.linwu.vue3.api.model.req.MenuListReq;
import com.linwu.vue3.api.model.req.MenuPageReq;
import com.linwu.vue3.api.model.resp.MenuLoadResp;
import com.linwu.vue3.api.model.resp.MenuPageResp;
import com.linwu.vue3.api.model.resp.MenuSimpleResp;
import com.linwu.vue3.api.utils.QueryWrapperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author linwu
 * @since 2022-08-31
 */
@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public BasePageListResp<MenuPageResp> selectPages(MenuPageReq req) {
        QueryWrapper<Menu> wrapper = QueryWrapperUtil.create(Menu.class);
        QueryWrapperUtil.notBlankLike(wrapper, Menu.NAME, req.getName());
        QueryWrapperUtil.notBlankEq(wrapper, Menu.CODE, req.getCode());
        QueryWrapperUtil.notNullEq(wrapper, Menu.PARENT_ID, req.getParentId());

        Page<Menu> page = menuDao.page(new Page<>(req.getPage(), req.getSize()), wrapper);
        return BasePageListResp.convert(page, (Menu entity) -> {
            MenuPageResp dictResp = new MenuPageResp();
            BeanUtils.copyProperties(entity, dictResp);
            return dictResp;
        });
    }

    public List<MenuLoadResp> load() {
        List<Menu> list = menuDao.list();
        Map<Long, List<Menu>> map = list.stream().collect(Collectors.groupingBy(bean -> bean.getParentId()));
        return getMenus(map, 0L);
    }

    private List<MenuLoadResp> getMenus(Map<Long, List<Menu>> map, Long parentId) {
        List<MenuLoadResp> result = Lists.newArrayList();

        List<Menu> menus = map.getOrDefault(parentId, Lists.newArrayList());

        for (Menu menu : menus) {
            MenuLoadResp resp = new MenuLoadResp();
            BeanUtils.copyProperties(menu, resp);
            result.add(resp);
            resp.setChildren(getMenus(map, menu.getId()));
        }

        return result;
    }


    public List<MenuSimpleResp> selectSimpleList(MenuListReq req) {
        QueryWrapper<Menu> wrapper = QueryWrapperUtil.create(Menu.class);
        QueryWrapperUtil.notBlankLike(wrapper, Menu.NAME, req.getName());
        QueryWrapperUtil.notBlankEq(wrapper, Menu.CODE, req.getCode());
        QueryWrapperUtil.notNullEq(wrapper, Dict.PARENT_ID, req.getParentId());
        List<Menu> list = menuDao.list(wrapper);

        return list.stream().map(bean -> {
            MenuSimpleResp resp = new MenuSimpleResp();
            BeanUtils.copyProperties(bean, resp);
            return resp;
        }).collect(Collectors.toList());

    }
}
