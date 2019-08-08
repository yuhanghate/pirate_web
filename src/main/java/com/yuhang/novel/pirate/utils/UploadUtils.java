package com.yuhang.novel.pirate.utils;

import com.yuhang.novel.pirate.constant.FileConstant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadUtils {

    /**
     * 保存上传的apk文件
     * @param file
     * @throws IOException
     */
    public static File saveFile(MultipartFile file) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy_MM_dd");
        String filename = MD5Utils.getMD5String(file.getOriginalFilename() + System.currentTimeMillis()) + ".apk";
        String filePath = FileConstant.UPLOADED_FOLDER_APK + File.separator + time.format(new Date()) + File.separator + filename;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return new File(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
