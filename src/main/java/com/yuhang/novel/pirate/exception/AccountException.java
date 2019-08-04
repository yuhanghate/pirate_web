package com.yuhang.novel.pirate.exception;

/**
 * 帐号登陆异常
 */
public class AccountException extends BaseException {

    public AccountException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
