package com.yuhang.novel.pirate.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("api/m/book")
@Api(value = "小说信息模块", description = "提供小说相关的api接口", tags = "小说api接口")
public class BookController {

    @ApiOperation(value = "获取收藏的小说列表", notes = "获取收藏的小说列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "get/collections")
    public Map<String, Object> postCollections() {

        return null;
    }
}
