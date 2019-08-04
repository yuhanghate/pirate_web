package com.yuhang.novel.pirate.service;


import com.yuhang.novel.pirate.dao.entity.UserEntity;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.LoginParamsModel;
import com.yuhang.novel.pirate.model.RegisterParamsModel;
import com.yuhang.novel.pirate.model.UserResultModel;

public interface UserService {

    /**
     * 登陆
     * * @param paramsModel
     * @return
     */
    UserResultModel login(LoginParamsModel paramsModel) throws AccountException;

    /**
     * 用户注册
     * @param paramsModel
     * @return
     */
    UserResultModel register(RegisterParamsModel paramsModel) throws AccountException;


}
