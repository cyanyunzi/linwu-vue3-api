package com.linwu.vue3.api.model.req;

import com.linwu.vue3.api.model.base.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author linwu
 * @since 2022-08-31
 */
@ApiModel
@Data
public class MenuPageReq extends BasePageReq {
    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("code")
    private String code;

    @ApiModelProperty("字典父级ID")
    private Long parentId;
}
