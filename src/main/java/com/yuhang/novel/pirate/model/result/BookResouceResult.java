package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.BookResoucePage;
import com.yuhang.novel.pirate.model.page.CollectionListPage;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "书源列表返回值")
public class BookResouceResult extends BaseResult {

    private BookResoucePage data;

    public BookResoucePage getData() {
        return data;
    }

    public BookResouceResult setData(BookResoucePage data) {
        this.data = data;
        return this;
    }
}
