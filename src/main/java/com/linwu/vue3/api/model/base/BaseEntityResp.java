package com.linwu.vue3.api.model.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntityResp extends BaseResp {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("创建人ID")
    private Long createdBy;
    @ApiModelProperty("修改人ID")
    private Long modifiedBy;
    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;
    @ApiModelProperty("修改时间")
    private LocalDateTime modifiedTime;
}
