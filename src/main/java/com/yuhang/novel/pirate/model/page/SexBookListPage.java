package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.SexBooksModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SexBookListPage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<SexBooksModel> list;

    public List<SexBooksModel> getList() {
        return list;
    }

    public SexBookListPage setList(List<SexBooksModel> list) {
        this.list = list;
        return this;
    }
}
