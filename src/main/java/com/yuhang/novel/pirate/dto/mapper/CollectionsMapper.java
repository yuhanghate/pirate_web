package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.CollectionsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.CollectionModel;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-08-06
 */
public interface CollectionsMapper extends BaseMapper<CollectionsEntity> {

    /**
     * 根据uid查询收藏列表并分页
     * @param uid
     * @return
     */
    Page<CollectionModel> selectUidByCollectionResultModelList(Page<CollectionModel> page, @Param("uid") String uid);

    /**
     * 删除收藏
     * @param bookid 小说id
     * @param resouceType 来源
     */
    void deleteByBookAndResouceType(String uid, String bookid, String resouceType);

    /**
     * 查询收藏对象
     * @param uid 用户id
     * @param bookid 小说id
     * @param resouceType 小说源
     * @return
     */
    CollectionsEntity selectCollectionResultModel(String uid, String bookid, String resouceType);
}
