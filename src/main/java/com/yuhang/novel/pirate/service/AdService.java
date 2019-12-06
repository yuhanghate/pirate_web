package com.yuhang.novel.pirate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.GameRecommentEntity;
import com.yuhang.novel.pirate.model.page.GameRecommentPage;
import org.springframework.stereotype.Service;

public interface AdService {

    /**
     * 获取游戏推荐
     * @return
     */
    GameRecommentPage getGameRecommentModel(int pageNum, int pageSize);
}
