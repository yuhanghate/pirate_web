package com.yuhang.novel.pirate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.page.BookResoucePage;
import com.yuhang.novel.pirate.model.params.ResouceInfoParams;

import java.io.IOException;
import java.util.List;

/**
 * 爬书源
 */
public interface BookResouceService {

//    /**
//     * 读取数据源列表
//     */
//    List<BookResouceModel> readBookResouceList() throws IOException;

//    /**
//     * 读取数据源列表
//     */
//    void readBookResouceDetails(List<BookResouceModel> list) throws IOException;

//    /**
//     * 根据热度获取源列表
//     * @param params
//     * @return
//     */
//    BookResoucePage getResouceListByHot(ResouceInfoParams params);

    /**
     * 根据权重查找
     * @param params
     * @return
     */
    BookResoucePage getResouceListByWeight(ResouceInfoParams params);

    /**
     * 爬取书本信息
     */
    void readBookInfo();


    /**
     * 爬快读数据
     */
    void readBookInfoKD();
}
