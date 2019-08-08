package com.yuhang.novel.pirate.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "版本更新")
public class VersionResult {


    /**
     * update : Yes
     * new_version : 0.8.3
     * apk_file_url : https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/apk/app-debug.apk
     * update_log : 1，添加删除信用卡接口
     2，添加vip认证
     3，区分自定义消费，一个小时不限制。
     4，添加放弃任务接口，小时内不生成。
     5，消费任务手动生成。
     * target_size : 5M
     * new_md5 : A818AD325EACC199BC62C552A32C35F2
     * constraint : false
     */

    @ApiModelProperty(value = "有新版本 Yes:有新版本  No:没有新版本", notes = "有新版本 Yes:有新版本  No:没有新版本", required = true)
    private String update;

    @ApiModelProperty(value = "新版本号", notes = "新版本号", required = true)
    private String newVersion;

    @ApiModelProperty(value = "apk下载地址", notes = "apk下载地址", required = true)
    private String apkFileUrl;

    @ApiModelProperty(value = "更新内容", notes = "更新内容")
    private String updateLog;

    @ApiModelProperty(value = "targetSize", notes = "targetSize")
    private String target_size;

    @ApiModelProperty(value = "文件md5", notes = "文件md5")
    private String newMd5;

    @ApiModelProperty(value = "是否强制更新",  notes = "是否强制更新")
    private Boolean  constraint;

    public String getUpdate() {
        return update;
    }

    public VersionResult setUpdate(String update) {
        this.update = update;
        return this;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public VersionResult setNewVersion(String newVersion) {
        this.newVersion = newVersion;
        return this;
    }

    public String getApkFileUrl() {
        return apkFileUrl;
    }

    public VersionResult setApkFileUrl(String apkFileUrl) {
        this.apkFileUrl = apkFileUrl;
        return this;
    }

    public String getUpdateLog() {
        return updateLog;
    }

    public VersionResult setUpdateLog(String updateLog) {
        this.updateLog = updateLog;
        return this;
    }

    public String getTarget_size() {
        return target_size;
    }

    public VersionResult setTarget_size(String target_size) {
        this.target_size = target_size;
        return this;
    }

    public String getNewMd5() {
        return newMd5;
    }

    public VersionResult setNewMd5(String newMd5) {
        this.newMd5 = newMd5;
        return this;
    }

    public Boolean getConstraint() {
        return constraint;
    }

    public VersionResult setConstraint(Boolean constraint) {
        this.constraint = constraint;
        return this;
    }
}
