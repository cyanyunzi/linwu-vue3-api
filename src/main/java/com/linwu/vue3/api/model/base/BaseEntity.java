package com.linwu.vue3.api.model.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity extends BaseMode {
    private Long id;
    private Long createdBy;
    private Long modifiedBy;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
}
