package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "配置文件")
public class ConfigModel {

    @ApiModelProperty(value = "是否显示推荐游戏 \ntrue:显示  \nfalse:不显示")
    private boolean isShowGameRecommended = false;

    @ApiModelProperty(value = "是否显示小黄书  \n true:显示 \n false:不显示")
    private boolean isShowSexBook = false;

    @ApiModelProperty(value = "是否开启会员 \ntrue:开启  \n false:不开启")
    private boolean isOpenVip = false;

    public boolean isOpenVip() {
        return isOpenVip;
    }

    public ConfigModel setOpenVip(boolean openVip) {
        isOpenVip = openVip;
        return this;
    }

    public boolean isShowGameRecommended() {
        return isShowGameRecommended;
    }

    public ConfigModel setShowGameRecommended(boolean showGameRecommended) {
        isShowGameRecommended = showGameRecommended;
        return this;
    }

    public boolean isShowSexBook() {
        return isShowSexBook;
    }

    public ConfigModel setShowSexBook(boolean showSexBook) {
        isShowSexBook = showSexBook;
        return this;
    }
}
