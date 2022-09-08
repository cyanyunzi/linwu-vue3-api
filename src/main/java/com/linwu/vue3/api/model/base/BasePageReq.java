package com.linwu.vue3.api.model.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BasePageReq extends BaseReq {
    @ApiModelProperty("分页页码")
    @NotNull(message = "缺少分页页码")
    @Min(value = 1,message = "分页页码必须大于0")
    protected Integer page;
    @ApiModelProperty("分页条数")
    @NotNull(message = "缺少分页条数")
    @Min(value = 1,message = "分页条数必须大于0")
    protected Integer size;
}
