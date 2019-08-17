package com.yuhang.novel.pirate.service.impl;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.dto.entity.AppVersionEntity;
import com.yuhang.novel.pirate.dto.mapper.AppVersionMapper;
import com.yuhang.novel.pirate.exception.VersionException;
import com.yuhang.novel.pirate.model.result.VersionResult;
import com.yuhang.novel.pirate.service.VersionService;
import com.yuhang.novel.pirate.utils.RxFileTool;
import com.yuhang.novel.pirate.utils.UploadUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VersionServiceImpl implements VersionService {

    @Resource
    AppVersionMapper mAppVersionMapper;

    @Override
    public VersionResult checkVersionUpdate(String versionName) throws VersionException {
        try {
            int oldVersionCode = mAppVersionMapper.selectVersionCode();
            int newVersionCode = Integer.valueOf(versionName.replace(".", ""));
            VersionResult versionResult = new VersionResult();
            if (oldVersionCode > newVersionCode) {
                //更新版本
                AppVersionEntity versionEntity = mAppVersionMapper.selectAppVersionEntity();
                BeanUtils.copyProperties(versionEntity, versionResult);
                versionResult.setUpdate("Yes");
                versionResult.setConstraint(versionEntity.getMustUpdate());
                return versionResult;
            } else {
                //没有新版本
               return  versionResult.setUpdate("No");
            }
        } catch (Exception e) {
            throw new VersionException(HttpConstant.HTTP_20007, "versionName 参数不正确");
        }

    }

    @Override
    public void uploadVersion(MultipartFile file, String newVersion, String updateLog, Boolean mustUpdate) throws VersionException {
        if (file.isEmpty()) {
            throw new VersionException(HttpConstant.HTTP_20008, "文件不存在");
        }
        if (StringUtils.isEmpty(newVersion)) {
            throw new VersionException(HttpConstant.HTTP_20007, "versionName 参数不能为空");
        }
        int newVersionCode = Integer.valueOf(newVersion.replace(".",""));
        int versionCode = mAppVersionMapper.selectVersionCode();
        if (newVersionCode <= versionCode) {
            throw new VersionException(HttpConstant.HTTP_20007, "versionName 参数不正确 必须大于当前版本");
        } else {
            File saveFile = UploadUtils.saveFile(file);
            if (saveFile != null) {
                //保存成功
                String name = saveFile.getName();

                String size = RxFileTool.getFileSize(saveFile);
                String md5 = RxFileTool.getFileMD5(saveFile);
                SimpleDateFormat time = new SimpleDateFormat("yyyy_MM_dd");
                AppVersionEntity entity = new AppVersionEntity();
                entity.setMustUpdate(mustUpdate);
                entity.setApkFileUrl("/apk/"+time.format(new Date())+"/"+name);
                entity.setCreateTime(new Date());
                entity.setNewMd5(md5);
                entity.setNewVersion(newVersion);
                entity.setNewVersionCode(newVersionCode);
                entity.setTargetSize(size);
                entity.setUpdateLog(updateLog);

                mAppVersionMapper.insert(entity);


            } else {
                throw new VersionException(HttpConstant.HTTP_20008, "文件写入失败");
            }
        }

    }

}
