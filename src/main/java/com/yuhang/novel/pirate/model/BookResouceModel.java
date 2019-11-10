package com.yuhang.novel.pirate.model;

import com.jayway.jsonpath.spi.json.JacksonJsonProvider;

/**
 * 网站源信息
 */
public class BookResouceModel {

    /**
     * 详情页地址
     */
    private String url;

    /**
     * 热度
     */
    private int heat;

    /**
     * 源地址名称
     */
    private String title;

    /**
     * 源地址是否有效检测时间
     */
    private String checkTime;

    /**
     * 源规则更新时间
     */
    private String updateTime;

    /**
     * 状态: 无法访问
     */
    private String status;

    /**
     * 书源网址
     */
    private String websiteUrl;

    /**
     * 书源规则JSON
     */
    private String resouceRule;


    public String getUrl() {
        return url;
    }

    public BookResouceModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getHeat() {
        return heat;
    }

    public BookResouceModel setHeat(int heat) {
        this.heat = heat;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookResouceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public BookResouceModel setCheckTime(String checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public BookResouceModel setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public BookResouceModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public BookResouceModel setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
        return this;
    }

    public String getResouceRule() {
        return resouceRule;
    }

    public BookResouceModel setResouceRule(String resouceRule) {
        this.resouceRule = resouceRule;
        return this;
    }

    @Override
    public String toString() {
        return new JacksonJsonProvider().toJson(this);
    }
}
