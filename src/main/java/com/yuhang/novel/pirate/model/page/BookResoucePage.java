package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.CollectionModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class BookResoucePage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<BookResouceModel> list;

    public List<BookResouceModel> getList() {
        return list;
    }

    public BookResoucePage setList(List<BookResouceModel> list) {
        this.list = list;
        return this;
    }
}
