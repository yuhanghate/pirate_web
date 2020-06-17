package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.SexBookContentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.result.SexBookContentResult;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-12-24
 */
public interface SexBookContentMapper extends BaseMapper<SexBookContentEntity> {

    /**
     * 获取内容
     * @param chapterid
     * @return
     */
    SexBookContentEntity selectContentByChapterid(int chapterid);
}
