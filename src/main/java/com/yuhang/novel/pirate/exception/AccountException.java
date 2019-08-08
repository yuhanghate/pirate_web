package com.yuhang.novel.pirate.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 帐号登陆异常
 */
public class AccountException extends AuthenticationException {
    private int errorCode;
    private String errorMsg;

    public AccountException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public AccountException setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public AccountException setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}
