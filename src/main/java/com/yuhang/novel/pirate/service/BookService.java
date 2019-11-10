package com.yuhang.novel.pirate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.exception.CollcetionException;
import com.yuhang.novel.pirate.model.AuthorBooksModel;
import com.yuhang.novel.pirate.model.BookSearchModel;
import com.yuhang.novel.pirate.model.CollectionModel;
import com.yuhang.novel.pirate.model.ReadHistoryModel;
import com.yuhang.novel.pirate.model.page.BookSearchPage;
import com.yuhang.novel.pirate.model.page.ReadHistoryPage;
import com.yuhang.novel.pirate.model.params.AddCollectionParams;
import com.yuhang.novel.pirate.model.params.ReadHistoryParams;

import java.util.List;

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
     * 最近阅读记录
     * @param uid 用户id
     * @param bookid 小说id
     * @return
     */
    ReadHistoryModel getReadHistoryModel( String uid, String bookid);

    /**
     * 插入或更新最近浏览记录
     * @param params 小说信息
     */
    void updateReadHistory(ReadHistoryParams params);

    /**
     * 最近收藏过的小说阅读记录
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param uid 用户id
     * @return
     */
    ReadHistoryPage getReadHistoryByCollectionModel(int pageNum, int pageSize, String uid);


    /**
     * 搜索书本
     * @param pageNum
     * @param pageSize
     * @param keyword 书名/作者
     * @return
     */
    BookSearchPage getBookSearchModel(int pageNum, int pageSize, String keyword);

    /**
     * 搜索一次增加权重
     * @param bookName
     * @param author
     */
    void setSearchWeight(String bookName, String author);

    /**
     * 获取作者所有作品
     * @param author 作者名
     */
    List<AuthorBooksModel> getAuthorBooks(String author);

    /**
     * 根据看书id搜索快读id
     * @return
     */
    BookSearchModel getBookSearchModelKs(String bookid);
}
