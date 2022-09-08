package com.linwu.vue3.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linwu.vue3.api.model.base.BaseEntity;
import lombok.Data;

/**
 * @author linwu
 * @since 2022-08-31
 */
@TableName("dict")
@Data
public class Dict extends BaseEntity {
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String CODE = "code";
    public static final String PARENT_ID = "parent_id";

    private String name;

    private String type;

    private String code;

    private Long parentId;
}
