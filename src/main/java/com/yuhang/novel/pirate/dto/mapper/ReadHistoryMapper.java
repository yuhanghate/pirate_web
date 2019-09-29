package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.ReadHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.ReadHistoryModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-08-06
 */
public interface ReadHistoryMapper extends BaseMapper<ReadHistoryEntity> {

    /**
     * 查找用户小说阅读记录
     *
     * @param uid 用户id
     * @return 阅读记录
     */
    Page<ReadHistoryModel>  selectReadHistoryEntityList(Page<ReadHistoryModel> page, @Param("uid") String uid);

    /**
     * 查找用户收藏过的小说的最后记录
     * @param page
     * @param uid
     * @return
     */
    Page<ReadHistoryModel> selectReadHistoryEntityByCollections(Page<ReadHistoryModel> page, @Param("uid") String uid);

    /**
     * 更新阅读时间
     *
     * @param uid        用户id
     * @param chapterid  章节id
     * @param createTime 阅读时间
     */
    void updateCreateTime(String uid, String bookid, String chapterid, Date createTime);

    /**
     * 查找最近阅读章节
     *
     * @param uid       用户id
     * @param bookid    小说id
     * @param chapterid 章节id
     * @return
     */
    ReadHistoryEntity selectReadHistoryEntity(String uid, String bookid, String chapterid);

    /**
     * 删除最近阅读记录
     *
     * @param uid       用户id
     * @param bookid    小说id
     * @param chapterid 章节id
     */
    void deleteReadHistoryEntity(String uid, String bookid, String chapterid);
}
