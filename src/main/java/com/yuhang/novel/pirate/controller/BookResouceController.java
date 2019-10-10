package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.service.BookResouceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/m/resouce")
@Api(value = "爬取小说源", description = "爬取小说源", tags = "爬取小说源")
public class BookResouceController {

    @Resource
    private BookResouceService mBookResouceService;

    @GetMapping("/build/website")
    @ApiOperation(value = "所有页面数据", notes = "所有页面数据")
    public BaseResult buildWebsite() {

        try {
            List<BookResouceModel> models = mBookResouceService.readBookResouceList();
            mBookResouceService.readBookResouceDetails(models);
            return new BaseResult();
        } catch (IOException e) {
            e.printStackTrace();
            return new BaseResult().setCode(HttpConstant.HTTP_20013).setMsg("爬取源数据失败");
        }

    }

    @GetMapping("/info/get")
    @ApiOperation(value = "获取源信息", notes = "获取源信息")
    public BaseResult getResouceInfo() {
        return new BaseResult();
    }

}
