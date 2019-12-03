package com.yuhang.novel.pirate.dto.mapper;

import com.yuhang.novel.pirate.dto.entity.BookSpiderHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-10-26
 */
public interface BookSpiderHistoryMapper extends BaseMapper<BookSpiderHistoryEntity> {

    BookSpiderHistoryEntity selectByUrl(int type);

    List<String> selectByKdAll(int type);
}
