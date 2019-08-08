package com.yuhang.novel.pirate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.exception.CollcetionException;
import com.yuhang.novel.pirate.model.ReadHistoryModel;
import com.yuhang.novel.pirate.model.page.ReadHistoryPage;
import com.yuhang.novel.pirate.model.params.AddCollectionParams;
import com.yuhang.novel.pirate.model.CollectionModel;
import com.yuhang.novel.pirate.model.params.ReadHistoryParams;

/**
 * 小说相关服务
 */
public interface BookService {


    /**
     * 查询小说收藏列表 分页
     * @param uid 用户id
     * @return 小说列表
     */
    Page<CollectionModel> getCollectiontModel(int pageNum, int pageSize, String uid);

    /**
     * 插入到收藏
     * @param paramsModel 收藏对象
     */
    void insertCollection(AddCollectionParams paramsModel) throws CollcetionException;


    /**
     * 从收藏列表删除
     * @param bookid 小说id
     * @param resouceType 小说数据来源
     */
    void deleteCollection(String bookid, String resouceType);

    /**
     * 最近阅读记录
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param uid 用户id
     * @return
     */
    ReadHistoryPage getReadHistoryModel(int pageNum, int pageSize, String uid);

    /**
     * 插入或更新最近浏览记录
     * @param params 小说信息
     */
    void updateReadHistory(ReadHistoryParams params);
}
