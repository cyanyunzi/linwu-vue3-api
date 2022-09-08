package com.linwu.vue3.api.controller;

import com.linwu.vue3.api.config.result.Result;
import com.linwu.vue3.api.model.base.BasePageListResp;
import com.linwu.vue3.api.model.req.DictPageReq;
import com.linwu.vue3.api.model.resp.DictPageResp;
import com.linwu.vue3.api.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author linwu
 * @since 2022-08-31
 */
@Api(tags = "字典")
@RestController
@RequestMapping("/dict")
public class DictController {

  @Autowired private DictService dictService;

  @ApiOperation("字典分页")
  @GetMapping("/page")
  public Result<BasePageListResp<DictPageResp>> selectPages(@Validated DictPageReq req) {
    return Result.ok(dictService.selectPages(req));
  }


}
