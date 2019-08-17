package com.yuhang.novel.pirate.dto.mapper;

import com.yuhang.novel.pirate.dto.entity.AppVersionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-08-08
 */
public interface AppVersionMapper extends BaseMapper<AppVersionEntity> {

    /**
     * 查询最后的版本号code
     * @return
     */
    int selectVersionCode();

    /**
     * 获取最后版本
     * @return 版本对象
     */
    AppVersionEntity selectAppVersionEntity();
}
