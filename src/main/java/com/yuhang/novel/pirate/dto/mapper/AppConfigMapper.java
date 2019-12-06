package com.yuhang.novel.pirate.dto.mapper;

import com.yuhang.novel.pirate.dto.entity.AppConfigEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-12-05
 */
public interface AppConfigMapper extends BaseMapper<AppConfigEntity> {

    public AppConfigEntity selectEntityByOne();
}
