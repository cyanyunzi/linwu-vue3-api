package com.linwu.vue3.api.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linwu.vue3.api.mapper.MenuMapper;
import com.linwu.vue3.api.model.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDao extends ServiceImpl<MenuMapper, Menu> {
}
