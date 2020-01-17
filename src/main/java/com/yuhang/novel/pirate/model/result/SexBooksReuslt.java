package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.SexBookListPage;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "小黄书列表")
public class SexBooksReuslt extends BaseResult{


    private SexBookListPage data;

    public SexBookListPage getData() {
        return data;
    }

    public SexBooksReuslt setData(SexBookListPage data) {
        this.data = data;
        return this;
    }

}
