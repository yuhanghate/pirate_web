package com.yuhang.novel.pirate.model;

import com.jayway.jsonpath.spi.json.JacksonJsonProvider;

/**
 * 网站源信息
 */
public class BookResouceListModel {

    /**
     * 详情页地址
     */
    private String url;

    /**
     * 热度
     */
    private int heat;

    /**
     * 源更新时间
     */
    private String updateTime;

    /**
     * 源名称
     */
    private String title;

    /**
     * 书源详情
     */
    private BookResouceDetailsModel detailsModel;

    public BookResouceDetailsModel getDetailsModel() {
        return detailsModel;
    }

    public BookResouceListModel setDetailsModel(BookResouceDetailsModel detailsModel) {
        this.detailsModel = detailsModel;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BookResouceListModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getHeat() {
        return heat;
    }

    public BookResouceListModel setHeat(int heat) {
        this.heat = heat;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public BookResouceListModel setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookResouceListModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return new JacksonJsonProvider().toJson(this);
    }
}
