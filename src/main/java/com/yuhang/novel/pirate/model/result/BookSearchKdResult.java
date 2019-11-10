package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.BookSearchModel;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "搜索书本")
public class BookSearchKdResult extends BaseResult {

    private BookSearchModel data;

    public BookSearchModel getData() {
        return data;
    }

    public BookSearchKdResult setData(BookSearchModel data) {
        this.data = data;
        return this;
    }
}
