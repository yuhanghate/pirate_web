package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.SexBookChapterListPage;
import com.yuhang.novel.pirate.model.page.SexBookListPage;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "小黄书章节")
public class SexBookChapterReuslt extends BaseResult{


    private SexBookChapterListPage data;

    public SexBookChapterListPage getData() {
        return data;
    }

    public SexBookChapterReuslt setData(SexBookChapterListPage data) {
        this.data = data;
        return this;
    }

}
