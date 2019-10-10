package com.yuhang.novel.pirate.service;

import com.yuhang.novel.pirate.model.BookResouceModel;

import java.io.IOException;
import java.util.List;

/**
 * 爬书源
 */
public interface BookResouceService {

    /**
     * 读取数据源列表
     */
    List<BookResouceModel> readBookResouceList() throws IOException;

    /**
     * 读取数据源列表
     */
    void readBookResouceDetails(List<BookResouceModel> list) throws IOException;

}
