package com.yuhang.novel.pirate.exception;

/**
 * 版本号异常
 */
public class VersionException extends BaseException {
    public VersionException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
