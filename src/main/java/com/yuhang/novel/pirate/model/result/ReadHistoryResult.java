package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.page.ReadHistoryPage;

/**
 * 阅读记录返回
 */
public class ReadHistoryResult extends BaseResult {

    private ReadHistoryPage data;

    public ReadHistoryPage getData() {
        return data;
    }

    public ReadHistoryResult setData(ReadHistoryPage data) {
        this.data = data;
        return this;
    }
}
