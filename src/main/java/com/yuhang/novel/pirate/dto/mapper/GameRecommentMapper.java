package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.GameRecommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.BookSearchModel;

/**
 * <p>
 * 游戏推荐表 Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-12-05
 */
public interface GameRecommentMapper extends BaseMapper<GameRecommentEntity> {

    /**
     * 获取游戏推荐列表
     * @param page
     * @return
     */
    Page<GameRecommentEntity> selectEntityList(Page<GameRecommentEntity> page);

}
