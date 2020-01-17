package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.SexBookContentModel;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "章节内容")
public class SexBookContentResult extends BaseResult {

    private SexBookContentModel data;

    public SexBookContentModel getData() {
        return data;
    }

    public SexBookContentResult setData(SexBookContentModel data) {
        this.data = data;
        return this;
    }
}
