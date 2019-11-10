package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.BookSearchModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class BookSearchPage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<BookSearchModel> list;

    public List<BookSearchModel> getList() {
        return list;
    }

    public BookSearchPage setList(List<BookSearchModel> list) {
        this.list = list;
        return this;
    }
}
