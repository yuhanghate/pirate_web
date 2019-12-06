package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 游戏推荐表
 * </p>
 *
 * @author yuhang
 * @since 2019-12-05
 */
@TableName("game_recomment")
public class GameRecommentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游戏名称
     */
    private String name;

    /**
     * 游戏图标
     */
    private String image;

    /**
     * 游戏类型 (策略类游戏)
     */
    private String gameType;

    /**
     * 游戏大小
     */
    private Long size;

    /**
     * 游戏简介
     */
    private String description;

    /**
     * APK包名
     */
    private String packageName;

    /**
     * 下载地址
     */
    private String downloadUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "GameRecommentEntity{" +
            "name=" + name +
            ", image=" + image +
            ", gameType=" + gameType +
            ", size=" + size +
            ", description=" + description +
            ", packageName=" + packageName +
            ", downloadUrl=" + downloadUrl +
        "}";
    }
}
