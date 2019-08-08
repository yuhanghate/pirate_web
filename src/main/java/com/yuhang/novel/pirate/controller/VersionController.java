package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.FileConstant;
import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.exception.VersionException;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.model.result.VersionResult;
import com.yuhang.novel.pirate.service.VersionService;
import com.yuhang.novel.pirate.utils.MD5Utils;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/m/version")
@Api(description = "版本更新", value = "提示检测版本更新等接口", tags = "版本更新api")
public class VersionController {


    @Resource
    VersionService mVersionService;

    @GetMapping("/upload")
    @ApiOperation(value = "跳转到上传页面", notes = "跳转到上传页面")
    public String upload() {
        return "upload";
    }

    @ApiOperation(value = "检测版本更新", notes = "检测版本更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/check/update")
    public VersionResult checkVersionUpdate(@ApiParam("versionName") @RequestParam String versionName) {
        try {
            return mVersionService.checkVersionUpdate(versionName);
        } catch (VersionException e) {
            e.printStackTrace();
            return new VersionResult().setUpdate("No");
        }
    }

    @ApiOperation(value = "上传apk", notes = "上传apk")
    @PostMapping("/upload")
    @ResponseBody
    public BaseResult singleFileUpload(@ApiParam(name = "file") @RequestParam("file") MultipartFile file,
                                       @ApiParam(name = "newVersion") @RequestParam String newVersion,
                                       @ApiParam(name = "updateLog") @RequestParam String updateLog,
                                       @ApiParam(name = "constraint") @RequestParam Boolean mustUpdate) {


        try {
            mVersionService.uploadVersion(file, newVersion,updateLog,mustUpdate);
            return new BaseResult().setCode(HttpConstant.HTTP_200).setMsg("上传成功");
        } catch (VersionException e) {
            e.printStackTrace();
            return new BaseResult(e.getErrorCode(), e.getErrorMsg());
        }

    }
}
