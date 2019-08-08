package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.model.ReadHistoryModel;

import java.util.List;

public class ReadHistoryPage extends BasePage {

    private List<ReadHistoryModel> list;

    public List<ReadHistoryModel> getList() {
        return list;
    }

    public ReadHistoryPage setList(List<ReadHistoryModel> list) {
        this.list = list;
        return this;
    }
}
