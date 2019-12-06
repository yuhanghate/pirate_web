package com.yuhang.novel.pirate.model.page;

import com.yuhang.novel.pirate.dto.entity.GameRecommentEntity;
import com.yuhang.novel.pirate.model.BookSearchModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "游戏推荐")
public class GameRecommentPage extends BasePage {

    @ApiModelProperty(value = "列表对象")
    private List<GameRecommentEntity> list;

    public List<GameRecommentEntity> getList() {
        return list;
    }

    public GameRecommentPage setList(List<GameRecommentEntity> list) {
        this.list = list;
        return this;
    }
}
