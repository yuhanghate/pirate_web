package com.yuhang.novel.pirate.service;


import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.AuthorizationInfoModel;
import com.yuhang.novel.pirate.model.UserModel;
import com.yuhang.novel.pirate.model.params.LoginParams;
import com.yuhang.novel.pirate.model.params.RegisterParams;
import com.yuhang.novel.pirate.model.params.UpdatePasswordParams;

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

    /**
     * 修改密码
     * @param params
     * @return
     * @throws AccountException
     */
    UserModel updatePassword(UpdatePasswordParams params) throws AccountException;

    /**
     * 指定邮箱用户是否存在
     * @param email
     * @return true:存在  false:不正在
     */
    boolean checkUserEmpty(String email);


}
