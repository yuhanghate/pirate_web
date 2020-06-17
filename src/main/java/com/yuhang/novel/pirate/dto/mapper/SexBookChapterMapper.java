package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.SexBookChapterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-12-24
 */
public interface SexBookChapterMapper extends BaseMapper<SexBookChapterEntity> {

    /**
     * 根据bookid获取章节列表
     * @param bookid
     * @return
     */
    Page<SexBookChapterEntity> selectBookChapters(Page<SexBookChapterEntity> page, int bookid);

}
