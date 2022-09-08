package com.linwu.vue3.api.model.resp;

import com.google.common.collect.Lists;
import com.linwu.vue3.api.model.base.BaseResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author linwu
 * @since 2022-08-31
 */
@ApiModel
@Data
public class MenuLoadResp extends BaseResp {
    @ApiModelProperty("菜单id")
    private Long id;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("code")
    private String code;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("上级ID")
    private Long parentId;

    @ApiModelProperty("子菜单")
    private List<MenuLoadResp> children = Lists.newArrayList();
}
