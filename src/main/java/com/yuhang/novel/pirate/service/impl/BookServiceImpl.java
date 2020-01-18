package com.yuhang.novel.pirate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.constant.UserConstant;
import com.yuhang.novel.pirate.dto.entity.*;
import com.yuhang.novel.pirate.dto.mapper.*;
import com.yuhang.novel.pirate.exception.CollcetionException;
import com.yuhang.novel.pirate.model.*;
import com.yuhang.novel.pirate.model.page.BookSearchPage;
import com.yuhang.novel.pirate.model.page.SexBookChapterListPage;
import com.yuhang.novel.pirate.model.page.SexBookListPage;
import com.yuhang.novel.pirate.model.page.ReadHistoryPage;
import com.yuhang.novel.pirate.model.params.AddCollectionParams;
import com.yuhang.novel.pirate.model.params.PageParams;
import com.yuhang.novel.pirate.model.params.ReadHistoryParams;
import com.yuhang.novel.pirate.service.BookService;
import com.yuhang.novel.pirate.utils.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 小说相关
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private HttpServletRequest request;

    @Resource
    CollectionsMapper mCollectionsMapper;

    @Resource
    ReadHistoryMapper mReadHistoryMapper;

    @Resource
    BooksMapper mBooksMapper;

    @Resource
    SexBooksMapper mSexBooksMapper;

    @Resource
    SexBookChapterMapper mSexBookChapterMapper;

    @Resource
    SexBookContentMapper mSexBookContentMapper;

    @Override
    public Page<CollectionModel> getCollectiontModel(int pageNum, int pageSize, String uid) {

        Page<CollectionModel> page = new Page<>(pageNum, pageSize);

        return mCollectionsMapper.selectUidByCollectionResultModelList(page, uid);
    }

    @Override
    public void insertCollection(AddCollectionParams paramsModel) throws CollcetionException {


        if (StringUtils.isEmpty(paramsModel.getBookid())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "bookid 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getResouceType())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "resouceType 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getAuthor())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "author 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getBookName())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "bookName 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getBookStatus())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "bookStatus 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getClassifyName())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "classifyName 请求参数不正常");
        } else if (StringUtils.isEmpty(paramsModel.getCover())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "conver 请求参数不正常");
        }

        String uid = JwtUtil.getUid(request.getHeader(UserConstant.TOKEN));
        CollectionsEntity resultModel = mCollectionsMapper.selectCollectionResultModel(uid, paramsModel.getBookid(), paramsModel.getResouceType());

        if (resultModel == null) {
            //插入收藏列表
            CollectionsEntity entity = new CollectionsEntity();
            BeanUtils.copyProperties(paramsModel, entity);
            entity.setCreateTime(new Date());
            entity.setUid(uid);
            mCollectionsMapper.insert(entity);
        } else {
            //更新收藏时间
            resultModel.setCreateTime(new Date());
            mCollectionsMapper.updateById(resultModel);

        }


    }

    @Override
    public void deleteCollection(String bookid, String resouceType) {
        String uid = JwtUtil.getUid(request.getHeader(UserConstant.TOKEN));
        mCollectionsMapper.deleteByBookAndResouceType(uid, bookid, resouceType);
    }

    @Override
    public ReadHistoryPage getReadHistoryModel(int pageNum, int pageSize, String uid) {
        Page<ReadHistoryModel> page = new Page<>(pageNum, pageSize);

        page = mReadHistoryMapper.selectReadHistoryEntityList(page, uid);

        ReadHistoryPage historyPage = new ReadHistoryPage();
        historyPage
                .setList(page.getRecords())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent())
                .setPageSize(page.getSize());

        return historyPage;
    }

    @Override
    public ReadHistoryModel getReadHistoryModel(String uid, String bookid) {

        ReadHistoryModel model = mReadHistoryMapper.selectReadHistoryEntityListByBookid(uid, bookid);
        return model;
    }

    @Override
    public void updateReadHistory(ReadHistoryParams params) {
        String uid = JwtUtil.getUid(request.getHeader(UserConstant.TOKEN));
        ReadHistoryEntity entity = mReadHistoryMapper.selectReadHistoryEntity(uid, params.getBookid(), params.getChapterid());

        if (entity == null) {
            //插入记录
            ReadHistoryEntity readHistoryEntity = new ReadHistoryEntity();
            BeanUtils.copyProperties(params, readHistoryEntity);
            readHistoryEntity.setCreateTime(new Date());
            readHistoryEntity.setUid(uid);
            mReadHistoryMapper.insert(readHistoryEntity);
        } else {
            //更新浏览时间
            entity.setCreateTime(new Date());
            entity.setTocId(params.getTocId());
            entity.setTocName(params.getTocName());
            mReadHistoryMapper.updateById(entity);
        }
    }

    @Override
    public ReadHistoryPage getReadHistoryByCollectionModel(int pageNum, int pageSize, String uid) {
        Page<ReadHistoryModel> page = new Page<>(pageNum, pageSize);

        page = mReadHistoryMapper.selectReadHistoryEntityByCollections(page, uid);

        ReadHistoryPage historyPage = new ReadHistoryPage();
        historyPage
                .setList(page.getRecords())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent())
                .setPageSize(page.getSize());

        return historyPage;
    }

    @Override
    public BookSearchPage getBookSearchModel(int pageNum, int pageSize, String keyword) {

        Page<BookSearchModel> page = new Page<>(pageNum, pageSize);

        page = mBooksMapper.selectSearchModelByBookName(page, "%" + keyword + "%");
        BookSearchPage searchPage = new BookSearchPage();
        searchPage.setList(page.getRecords())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent())
                .setPageSize(page.getSize());
        return searchPage;
    }

    @Override
    public void setSearchWeight(String bookName, String author) {

        BooksEntity entity = mBooksMapper.selectByAuthorAndBookName(author, bookName);

        entity.setWeight(entity.getWeight() + 1);
        mBooksMapper.updateById(entity);
    }

    @Override
    public List<AuthorBooksModel> getAuthorBooks(String author) {
        return mBooksMapper.selectAuthorBooksByAuthor(author);
    }

    @Override
    public BookSearchModel getBookSearchModelKs(String bookid) {

        BookSearchModel model = mBooksMapper.selectSearchModelByBookidKs(bookid);
        return model;
    }

    @Override
    public SexBookListPage getSexBooks(PageParams params) {
        Page<SexBooksEntity> page = new Page<>(params.getPageNum(), params.getPageSize());
        mSexBooksMapper.selectSexBooks(page);

        SexBookListPage models = new SexBookListPage();
        List<SexBooksModel> list = new ArrayList<>();
        page.getRecords().parallelStream()
                .forEach(entity -> {
                    SexBooksModel model = new SexBooksModel();
                    BeanUtils.copyProperties(entity, model);
                    model.setBookId(entity.getId());
                    list.add(model);
                });

        models.setList(list)
                .setPageSize(page.getSize())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent());

        return models;
    }

    @Override
    public List<SexBooksModel> getSexBooksRand(int limit) {
        return mSexBooksMapper.selectSexBookByRand(limit);
    }

    @Override
    public SexBookChapterListPage getSexBookChapters(int bookid) {
        Page<SexBookChapterEntity> page = new Page<SexBookChapterEntity>();
        mSexBookChapterMapper.selectBookChapters(page, bookid);


        SexBookChapterListPage models = new SexBookChapterListPage();
        List<SexBookChapterModel> list = new ArrayList<>();
        List<SexBookChapterEntity> records = page.getRecords();
        for (SexBookChapterEntity entity : records) {
            SexBookChapterModel model = new SexBookChapterModel();
            BeanUtils.copyProperties(entity, model);
            model.setChapterId(entity.getId());
            list.add(model);
        }

        models.setList(list)
                .setPageSize(page.getSize())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent());

        return models;
    }

    @Override
    public SexBookContentModel getSexBookContent(int chapterid) {
        SexBookContentEntity entity = mSexBookContentMapper.selectContentByChapterid(chapterid);
        SexBookContentModel model = new SexBookContentModel();
        BeanUtils.copyProperties(entity, model);

        return model;
    }
}
