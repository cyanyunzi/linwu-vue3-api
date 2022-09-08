package com.linwu.vue3.api.model.resp;

import com.linwu.vue3.api.model.base.BaseEntityResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author linwu
 * @since 2022-08-31
 */
@ApiModel
@Data
public class MenuPageResp extends BaseEntityResp {

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
}
