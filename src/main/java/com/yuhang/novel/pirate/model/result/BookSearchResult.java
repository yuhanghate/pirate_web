package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.BookSearchPage;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "搜索书本")
public class BookSearchResult extends BaseResult {

    private BookSearchPage data;

    public BookSearchPage getData() {
        return data;
    }

    public BookSearchResult setData(BookSearchPage data) {
        this.data = data;
        return this;
    }
}
