package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-08-08
 */
@TableName("app_version")
public class AppVersionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新版本号
     */
    private String newVersion;

    /**
     * apk下载地址
     */
    private String apkFileUrl;

    /**
     * 更新内容
     */
    private String updateLog;

    /**
     * apk大小
     */
    private String targetSize;

    /**
     * 文件md5
     */
    private String newMd5;

    /**
     * 0:不强制更新  1:强制更新
     */
    private Boolean mustUpdate;

    /**
     * 新版本号int型, 用于排序
     */
    private int newVersionCode;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }
    public String getApkFileUrl() {
        return apkFileUrl;
    }

    public void setApkFileUrl(String apkFileUrl) {
        this.apkFileUrl = apkFileUrl;
    }
    public String getUpdateLog() {
        return updateLog;
    }

    public void setUpdateLog(String updateLog) {
        this.updateLog = updateLog;
    }
    public String getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(String targetSize) {
        this.targetSize = targetSize;
    }
    public String getNewMd5() {
        return newMd5;
    }

    public void setNewMd5(String newMd5) {
        this.newMd5 = newMd5;
    }

    public Boolean getMustUpdate() {
        return mustUpdate;
    }

    public AppVersionEntity setMustUpdate(Boolean mustUpdate) {
        this.mustUpdate = mustUpdate;
        return this;
    }

    public int getNewVersionCode() {
        return newVersionCode;
    }

    public void setNewVersionCode(int newVersionCode) {
        this.newVersionCode = newVersionCode;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AppVersionEntity{" +
            "newVersion=" + newVersion +
            ", apkFileUrl=" + apkFileUrl +
            ", updateLog=" + updateLog +
            ", targetSize=" + targetSize +
            ", newMd5=" + newMd5 +
            ", constraint=" + mustUpdate +
            ", newVersionCode=" + newVersionCode +
            ", createTime=" + createTime +
        "}";
    }
}
