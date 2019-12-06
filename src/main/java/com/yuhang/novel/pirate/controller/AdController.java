package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.model.page.GameRecommentPage;
import com.yuhang.novel.pirate.model.result.GameRecommentResult;
import com.yuhang.novel.pirate.service.AdService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/m/ad")
@Api(description = "广告api", value = "广告api接口", tags = "广告api接口")
public class AdController {

    @Resource
    AdService mAdService;

    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", dataType = "Integer", value = "页数", required = true),
            @ApiImplicitParam(type = "query", name = "pageSize", dataType = "Integer", value = "每页条数", required = true)
    })
    @ApiOperation(value = "获取游戏推荐列表", notes = "获取游戏推荐列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/game/recomment")
    public GameRecommentResult getGameRecomment(@ApiParam int pageNum, @ApiParam int pageSize) {

        GameRecommentPage page = mAdService.getGameRecommentModel(pageNum, pageSize);
        GameRecommentResult result = new GameRecommentResult();
        result.setData(page);
        return result;
    }
}
