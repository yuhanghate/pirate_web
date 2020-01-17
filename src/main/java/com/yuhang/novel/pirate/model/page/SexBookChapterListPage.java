package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.SexBookChapterModel;
import com.yuhang.novel.pirate.model.SexBooksModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SexBookChapterListPage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<SexBookChapterModel> list;

    public List<SexBookChapterModel> getList() {
        return list;
    }

    public SexBookChapterListPage setList(List<SexBookChapterModel> list) {
        this.list = list;
        return this;
    }
}
