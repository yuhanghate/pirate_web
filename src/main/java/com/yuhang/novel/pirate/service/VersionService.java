package com.yuhang.novel.pirate.service;

import com.yuhang.novel.pirate.exception.VersionException;
import com.yuhang.novel.pirate.model.result.VersionResult;
import org.springframework.web.multipart.MultipartFile;

public interface VersionService {

    /**
     * 检测版本号
     * @param versionName
     * @return
     */
    VersionResult checkVersionUpdate(String versionName) throws VersionException;

    /**
     * 上传apk版本
     */
    void uploadVersion(MultipartFile file, String newVersion, String updateLog, Boolean mustUpdate) throws VersionException;

    /**
     * 获取最新APK下载地址
     * @return
     */
    String getDownloadApkUrl();
}
