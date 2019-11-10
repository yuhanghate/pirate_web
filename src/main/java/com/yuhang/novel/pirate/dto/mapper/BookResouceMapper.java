package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.BookResouceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.BookResouceModel;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-10-03
 */
public interface BookResouceMapper extends BaseMapper<BookResouceEntity> {

    /**
     * 根据源地址查询
     * @param website
     * @return
     */
    BookResouceEntity selectByWebsite(String website);

    /**
     * 根据热度查询
     * @return
     */
    Page<BookResouceModel> selectListByHot(Page<BookResouceModel> page);

    /**
     * 根据权重查询
     * @return
     */
    Page<BookResouceModel> selectListByWeight(Page<BookResouceModel> page);
}
