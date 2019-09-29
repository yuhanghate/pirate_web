package com.yuhang.novel.pirate.exception;

/**
 * 邮箱相关
 */
public class MailException extends BaseException {
    public MailException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
