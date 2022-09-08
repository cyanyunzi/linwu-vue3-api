package com.linwu.vue3.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linwu.vue3.api.model.base.BaseEntity;
import lombok.Data;

/**
 * @author linwu
 * @since 2022-08-31
 */
@TableName("menu")
@Data
public class Menu extends BaseEntity {
    public static final String NAME = "name";
    public static final String ICON = "icon";
    public static final String CODE = "code";
    public static final String PATH = "path";
    public static final String PARENT_ID = "parent_id";

    private String name;

    private String code;

    private String icon;

    private String path;

    private Long parentId;
}
