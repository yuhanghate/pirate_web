package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.ReadHistoryModel;

/**
 * 阅读记录
 */
public class ReadHistoryBookResult  extends  BaseResult{

    private ReadHistoryModel data;

    public ReadHistoryModel getData() {
        return data;
    }

    public ReadHistoryBookResult setData(ReadHistoryModel data) {
        this.data = data;
        return this;
    }
}
