package com.linwu.vue3.api.model.resp;

import com.linwu.vue3.api.model.base.BaseResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author linwu
 * @since 2022-08-31
 */
@ApiModel
@Data
public class MenuSimpleResp extends BaseResp {
    @ApiModelProperty("菜单id")
    private Long id;
    @ApiModelProperty("菜单名称")
    private String name;
}
