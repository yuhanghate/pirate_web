package com.yuhang.novel.pirate.model;

import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 书源详情
 */
public class BookResouceDetailsModel {

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
    private String resouceJson;

    public String getTitle() {
        return title;
    }

    public BookResouceDetailsModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public BookResouceDetailsModel setCheckTime(String checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public BookResouceDetailsModel setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public BookResouceDetailsModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public BookResouceDetailsModel setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
        return this;
    }

    public String getResouceJson() {
        return resouceJson;
    }

    public BookResouceDetailsModel setResouceJson(String resouceJson) {
        this.resouceJson = resouceJson;
        return this;
    }

    @Override
    public String toString() {

        return new JacksonJsonProvider().toJson(this);
    }
}

