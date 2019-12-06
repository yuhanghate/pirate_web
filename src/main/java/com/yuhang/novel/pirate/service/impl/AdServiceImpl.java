package com.yuhang.novel.pirate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.GameRecommentEntity;
import com.yuhang.novel.pirate.dto.mapper.GameRecommentMapper;
import com.yuhang.novel.pirate.model.BookSearchModel;
import com.yuhang.novel.pirate.model.page.GameRecommentPage;
import com.yuhang.novel.pirate.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdServiceImpl implements AdService {

    @Resource
    private GameRecommentMapper mGameMapper;

    @Override
    public GameRecommentPage getGameRecommentModel(int pageNum, int pageSize) {
        Page<GameRecommentEntity> page = new Page<>(pageNum, pageSize);
        mGameMapper.selectEntityList(page);

        GameRecommentPage model = new GameRecommentPage();
        model.setList(page.getRecords())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent())
                .setPageSize(page.getSize());
        return model;
    }
}
