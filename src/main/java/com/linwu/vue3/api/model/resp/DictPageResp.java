package com.linwu.vue3.api.model.resp;

import com.linwu.vue3.api.model.base.BaseEntityResp;
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
public class DictPageResp extends BaseEntityResp {
    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("字典类型")
    private String type;

    @ApiModelProperty("字典code")
    private String code;

    @ApiModelProperty("字典父级ID")
    private Long parentId;
}
