package com.yuhang.novel.pirate.dao.mapper;

import com.yuhang.novel.pirate.dao.entity.ReadHistoryEntity;
import java.util.List;

/**
 * 阅读记录
 */
public interface ReadHistoryEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReadHistoryEntity record);

    ReadHistoryEntity selectByPrimaryKey(Integer id);

    List<ReadHistoryEntity> selectAll();

    int updateByPrimaryKey(ReadHistoryEntity record);
}