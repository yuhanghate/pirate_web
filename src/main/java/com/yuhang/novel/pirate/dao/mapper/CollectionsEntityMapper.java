package com.yuhang.novel.pirate.dao.mapper;

import com.yuhang.novel.pirate.dao.entity.CollectionsEntity;
import java.util.List;

/**
 * 收藏
 */
public interface CollectionsEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionsEntity record);

    CollectionsEntity selectByPrimaryKey(Integer id);

    List<CollectionsEntity> selectAll();

    int updateByPrimaryKey(CollectionsEntity record);
}