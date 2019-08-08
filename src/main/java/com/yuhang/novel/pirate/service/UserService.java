package com.yuhang.novel.pirate.service;


import com.yuhang.novel.pirate.model.AuthorizationInfoModel;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.params.LoginParams;
import com.yuhang.novel.pirate.model.params.RegisterParams;
import com.yuhang.novel.pirate.model.UserModel;

public interface UserService {

    /**
     * 登陆
     * * @param paramsModel
     * @return
     */
    UserModel login(LoginParams paramsModel) throws AccountException;

    /**
     * 用户注册
     * @param paramsModel
     * @return
     */
    UserModel register(RegisterParams paramsModel) throws AccountException;

    /**
     * 获取认证对象
     * @param uid
     * @return
     */
    AuthorizationInfoModel selectByPrimaryKey(String uid);


}
