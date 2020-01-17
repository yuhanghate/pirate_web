package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.SexBooksModel;
import com.yuhang.novel.pirate.model.page.SexBookListPage;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "小黄书列表随机")
public class SexBooksRandReuslt extends BaseResult{


    private List<SexBooksModel> data;

    public List<SexBooksModel> getData() {
        return data;
    }

    public SexBooksRandReuslt setData(List<SexBooksModel> data) {
        this.data = data;
        return this;
    }

}
