package com.yuhang.novel.pirate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.exception.CollcetionException;
import com.yuhang.novel.pirate.model.page.CollectionListPage;
import com.yuhang.novel.pirate.model.page.ReadHistoryPage;
import com.yuhang.novel.pirate.model.params.AddCollectionParams;
import com.yuhang.novel.pirate.model.CollectionModel;
import com.yuhang.novel.pirate.model.params.ReadHistoryParams;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.model.result.CollectionListResult;
import com.yuhang.novel.pirate.model.result.ReadHistoryResult;
import com.yuhang.novel.pirate.service.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/m/book")
@Api(value = "小说信息模块", description = "提供小说相关的api接口", tags = "小说api接口")
public class BookController extends BaseController {


    @Autowired
    private HttpServletRequest request;

    @Resource
    private BookService mBookService;


    /**
     * 返回收藏列表
     *
     * @param pageNum  页数
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/collection/list")
    @ApiOperation(value = "获取收藏的小说列表", notes = "获取收藏的小说列表", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionListResult getCollectionList(@ApiParam(name = "pageNum", value = "页数", required = true) @RequestParam int pageNum,
                                                  @ApiParam(name = "pageSize", value = "每页条数", required = true) @RequestParam int pageSize) {
        Page<CollectionModel> model = mBookService.getCollectiontModel(pageNum, pageSize, getUid(request));

        CollectionListPage pageResultModel = new CollectionListPage();
        pageResultModel.setTotal(model.getTotal());
        pageResultModel.setPageNum(model.getCurrent());
        pageResultModel.setPageSize(model.getSize());
        pageResultModel.setList(model.getRecords());

        CollectionListResult result = new CollectionListResult();
        result.setCode(HttpConstant.HTTP_200);
        result.setMsg("成功");
        result.setData(pageResultModel);
        return result;
    }

    /**
     * 收藏小说
     * @param paramsModel
     * @return
     */
    @ApiOperation(value = "添加小说到收藏列表", notes = "添加小说到收藏列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/collection/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult postAddCollection(@RequestBody AddCollectionParams paramsModel) {

        try {
            mBookService.insertCollection(paramsModel);
            return new BaseResult().setCode(HttpConstant.HTTP_200).setMsg("成功");
        } catch (CollcetionException e) {
            e.printStackTrace();
            return new BaseResult().setCode(e.getErrorCode()).setMsg(e.getErrorMsg());
        }

    }

    /**
     * 删除小说收藏
     * @param bookid
     * @param resouceType
     * @return
     */
    @DeleteMapping(value = "/collection/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "删除收藏列表", notes = "删除收藏", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult postDeletecollection(@RequestParam @ApiParam(name = "bookid", value = "小说id", required = true) String bookid,
                                           @RequestParam @ApiParam(name = "resouceType", value = "小说源(KS:看书神器)", required = true) String resouceType) {
        mBookService.deleteCollection(bookid, resouceType);
        return new BaseResult().setCode(HttpConstant.HTTP_200).setMsg("成功");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", dataType = "Integer", value = "页数", required = true),
            @ApiImplicitParam(type = "query", name = "pageSize", dataType = "Integer", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询阅读记录列表", notes = "查询阅读记录列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/read/history/list")
    public ReadHistoryResult getReadHistoryList(@ApiParam int pageNum, @ApiParam int pageSize) {

        ReadHistoryPage model = mBookService.getReadHistoryModel(pageNum, pageSize, getUid(request));
        return (ReadHistoryResult) new ReadHistoryResult().setData(model).setCode(HttpConstant.HTTP_200).setMsg("成功");
    }

    @PostMapping("/read/history/update")
    @ApiOperation(value = "更新最近游览记录", notes = "更新最近浏览记录", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult updateReadHistory(@RequestBody ReadHistoryParams params) {

        mBookService.updateReadHistory(params);
        return new BaseResult();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", dataType = "Integer", value = "页数", required = true),
            @ApiImplicitParam(type = "query", name = "pageSize", dataType = "Integer", value = "每页条数", required = true)
    })
    @ApiOperation(value = "查询收藏过的小说阅读记录列表", notes = "查询阅读记录列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/read/collection/history/list")
    public ReadHistoryResult getReadHistoryByCollectionList(@ApiParam int pageNum, @ApiParam int pageSize) {

        ReadHistoryPage model = mBookService.getReadHistoryByCollectionModel(pageNum, pageSize, getUid(request));
        return (ReadHistoryResult) new ReadHistoryResult().setData(model).setCode(HttpConstant.HTTP_200).setMsg("成功");
    }
}
