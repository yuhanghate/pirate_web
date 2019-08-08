package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.CollectionModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CollectionListPage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<CollectionModel> list;

    public List<CollectionModel> getList() {
        return list;
    }

    public CollectionListPage setList(List<CollectionModel> list) {
        this.list = list;
        return this;
    }
}
