package com.yuhang.novel.pirate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.constant.UserConstant;
import com.yuhang.novel.pirate.dto.entity.CollectionsEntity;
import com.yuhang.novel.pirate.dto.entity.ReadHistoryEntity;
import com.yuhang.novel.pirate.dto.mapper.CollectionsMapper;
import com.yuhang.novel.pirate.dto.mapper.ReadHistoryMapper;
import com.yuhang.novel.pirate.exception.CollcetionException;
import com.yuhang.novel.pirate.model.CollectionModel;
import com.yuhang.novel.pirate.model.ReadHistoryModel;
import com.yuhang.novel.pirate.model.page.ReadHistoryPage;
import com.yuhang.novel.pirate.model.params.AddCollectionParams;
import com.yuhang.novel.pirate.model.params.ReadHistoryParams;
import com.yuhang.novel.pirate.service.BookService;
import com.yuhang.novel.pirate.utils.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
        }else if (StringUtils.isEmpty(paramsModel.getAuthor())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "author 请求参数不正常");
        }else if (StringUtils.isEmpty(paramsModel.getBookName())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "bookName 请求参数不正常");
        }else if (StringUtils.isEmpty(paramsModel.getBookStatus())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "bookStatus 请求参数不正常");
        }else if (StringUtils.isEmpty(paramsModel.getClassifyName())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "classifyName 请求参数不正常");
        }else if (StringUtils.isEmpty(paramsModel.getCover())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "conver 请求参数不正常");
        }else if (StringUtils.isEmpty(paramsModel.getDescription())) {
            throw new CollcetionException(HttpConstant.HTTP_20007, "description 请求参数不正常");
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
            mReadHistoryMapper.updateById(entity);
        }
    }
}