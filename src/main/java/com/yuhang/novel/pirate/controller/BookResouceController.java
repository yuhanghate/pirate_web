package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.dto.entity.BookResouceEntity;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.page.BookResoucePage;
import com.yuhang.novel.pirate.model.params.ResouceInfoParams;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.model.result.BookResouceResult;
import com.yuhang.novel.pirate.service.BookResouceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/m/resouce")
@Api(value = "爬取小说源", description = "爬取小说源", tags = "爬取小说源")
public class BookResouceController {

    @Resource
    private BookResouceService mBookResouceService;

//    @GetMapping("/build/website")
//    @ApiOperation(value = "所有页面数据", notes = "所有页面数据")
//    public BaseResult buildWebsite() {
//
//        try {
//            List<BookResouceModel> models = mBookResouceService.readBookResouceList();
//            mBookResouceService.readBookResouceDetails(models);
//            return new BaseResult();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new BaseResult().setCode(HttpConstant.HTTP_20013).setMsg("爬取源数据失败");
//        }
//
//    }

//    @PostMapping("/list/get")
//    @ApiOperation(value = "获取源信息", notes = "获取源信息")
//    public BookResouceResult getResouceInfo(@RequestBody ResouceInfoParams params) {
//        if (params.getType() == 0) {
//            //热度搜索
//            BookResoucePage data = mBookResouceService.getResouceListByHot(params);
//            JacksonJsonParser parser = new JacksonJsonParser();
//            for (BookResouceModel resouceEntity : data.getList()) {
//                String rule = resouceEntity.getResouceRule();
//                Map<String, Object> map = parser.parseMap(rule);
//                String ruleSearchUrl = (String) map.get("ruleSearchUrl");
//                System.out.println(ruleSearchUrl+"\n");
//            }
//            return new BookResouceResult().setData(data);
//
//        } else if (params.getType() == 1) {
//            //权重搜索
//            BookResoucePage data = mBookResouceService.getResouceListByWeight(params);
//            return new BookResouceResult().setData(data);
//
//        }
//        return (BookResouceResult) new BookResouceResult().setCode(HttpConstant.HTTP_20013).setMsg("失败");
//    }

    @PostMapping("/book/info/read")
    @ApiOperation(value = "获取小说信息", notes = "获取小说信息")
    public BaseResult readBookInfo() {
        mBookResouceService.readBookInfo();
        return new BaseResult();
    }

    @PostMapping("/book/info/read/kd")
    @ApiOperation(value = "爬快读所有书籍信息", notes = "爬快读所有书籍信息")
    public BaseResult readBookKdInfo() {
        mBookResouceService.readBookInfoKD();
        return new BaseResult();
    }


}
