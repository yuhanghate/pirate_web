package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-12-05
 */
@TableName("app_config")
public class AppConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否显示游戏推荐 0:显示  1:不显示
     */
    private Integer showGameRecommended;

    /**
     * 显示小黄书  0:显示  1:不显示
     */
    private Integer showSexBook;

    private Integer isOpenVip;

    public Integer getIsOpenVip() {
        return isOpenVip;
    }

    public AppConfigEntity setIsOpenVip(Integer isOpenVip) {
        this.isOpenVip = isOpenVip;
        return this;
    }

    public Integer getShowGameRecommended() {
        return showGameRecommended;
    }

    public void setShowGameRecommended(Integer showGameRecommended) {
        this.showGameRecommended = showGameRecommended;
    }
    public Integer getShowSexBook() {
        return showSexBook;
    }

    public void setShowSexBook(Integer showSexBook) {
        this.showSexBook = showSexBook;
    }

    @Override
    public String toString() {
        return "AppConfigEntity{" +
            "showGameRecommended=" + showGameRecommended +
            ", showSexBook=" + showSexBook +
        "}";
    }
}
