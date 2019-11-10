package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-10-03
 */
@TableName("book_resouce")
public class BookResouceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer heat;

    private String title;

    @TableField("checkTime")
    private Date checkTime;

    @TableField("updateTime")
    private Date updateTime;

    private String status;

    private String websiteUrl;

    private String resouceRule;

    private Date createTime;

    private int weight;

    /**
     * 快读渠道源id
     */
    private String tocId;

    /**
     * 快读渠道源名称
     */
    private String tocName;

    public String getTocId() {
        return tocId;
    }

    public BookResouceEntity setTocId(String tocId) {
        this.tocId = tocId;
        return this;
    }

    public String getTocName() {
        return tocName;
    }

    public BookResouceEntity setTocName(String tocName) {
        this.tocName = tocName;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public BookResouceEntity setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getId() {
        return id;
    }

    public BookResouceEntity setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
    public String getResouceRule() {
        return resouceRule;
    }

    public void setResouceRule(String resouceRule) {
        this.resouceRule = resouceRule;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BookResouceEntity{" +
            "heat=" + heat +
            ", title=" + title +
            ", checkTime=" + checkTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", websiteUrl=" + websiteUrl +
            ", resouceRule=" + resouceRule +
            ", createTime=" + createTime +
        "}";
    }
}
