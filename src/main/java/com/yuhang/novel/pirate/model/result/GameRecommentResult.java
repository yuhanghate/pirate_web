package com.yuhang.novel.pirate.model.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.GameRecommentEntity;
import com.yuhang.novel.pirate.model.page.GameRecommentPage;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "游戏推荐")
public class GameRecommentResult extends BaseResult {

    private GameRecommentPage data;

    public GameRecommentPage getData() {
        return data;
    }

    public GameRecommentResult setData(GameRecommentPage data) {
        this.data = data;
        return this;
    }
}
