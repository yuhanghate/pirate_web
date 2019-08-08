package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.CollectionListPage;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "收藏列表返回值")
public class CollectionListResult extends BaseResult {

    private CollectionListPage data;


    public CollectionListPage getData() {
        return data;
    }

    public CollectionListResult setData(CollectionListPage data) {
        this.data = data;
        return this;
    }
}
