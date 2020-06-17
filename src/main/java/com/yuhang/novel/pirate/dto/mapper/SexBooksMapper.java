package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.SexBooksEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.SexBooksModel;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-12-24
 */
public interface SexBooksMapper extends BaseMapper<SexBooksEntity> {

    /**
     * 获取小黄书列表
     * @param page
     * @return
     */
    Page<SexBooksEntity> selectSexBooks(Page<SexBooksEntity> page);

    /**
     * 随机获取小黄书
     * @return
     */
    List<SexBooksModel> selectSexBookByRand(int limit);

}
