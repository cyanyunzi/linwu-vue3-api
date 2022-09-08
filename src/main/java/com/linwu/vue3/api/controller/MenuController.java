package com.linwu.vue3.api.controller;

import com.linwu.vue3.api.config.result.Result;
import com.linwu.vue3.api.model.base.BasePageListResp;
import com.linwu.vue3.api.model.req.MenuListReq;
import com.linwu.vue3.api.model.req.MenuPageReq;
import com.linwu.vue3.api.model.resp.MenuLoadResp;
import com.linwu.vue3.api.model.resp.MenuPageResp;
import com.linwu.vue3.api.model.resp.MenuSimpleResp;
import com.linwu.vue3.api.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前端控制器
 *
 * @author linwu
 * @since 2022-08-31
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired private MenuService menuService;

  @ApiOperation("菜单分页")
  @GetMapping("/page")
  public Result<BasePageListResp<MenuPageResp>> selectPages(@Validated MenuPageReq req) {
    return Result.ok(menuService.selectPages(req));
  }

  @ApiOperation("菜单加载")
  @GetMapping("/load")
  public Result<List<MenuLoadResp>> load() {
    return Result.ok(menuService.load());
  }

  @ApiOperation("菜单列表")
  @GetMapping("/simpleList")
  public Result<List<MenuSimpleResp>> selectSimpleList(MenuListReq req) {
    return Result.ok(menuService.selectSimpleList(req));
  }
}
