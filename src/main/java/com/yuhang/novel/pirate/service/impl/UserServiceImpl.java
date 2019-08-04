package com.yuhang.novel.pirate.service.impl;

import com.yuhang.novel.pirate.config.RandomConfig;
import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.dao.entity.UserEntity;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.dao.mapper.UserMapper;
import com.yuhang.novel.pirate.model.LoginParamsModel;
import com.yuhang.novel.pirate.model.RegisterParamsModel;
import com.yuhang.novel.pirate.model.UserResultModel;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.utils.RegexUtils;
import com.yuhang.novel.pirate.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户信息:
 * 登陆/注册等
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mUserMapper;

//    @Autowired
//    private RandomConfig mRandomConfig;

    @Override
    public UserResultModel login(LoginParamsModel paramsModel) throws AccountException {
        UserEntity entity = mUserMapper.selectByUsername(paramsModel.getUsername());
        if (entity == null) {
            throw new AccountException(HttpConstant.HTTP_20001, "帐号不存在");
        }
        if (!entity.getPassword().equals(paramsModel.getPassword())) {
            throw new AccountException(HttpConstant.HTTP_20002, "密码不正确");
        }
        //更新最后登陆时间
        entity.setLastLoginTime(new Date());
        mUserMapper.updateLastTimeByPrimaryKey(entity);

        return new UserResultModel().setId(entity.getId())
                .setEmail(entity.getEmail())
                .setTel(entity.getTel())
                .setUsername(entity.getUsername());
    }

    @Override
    public UserResultModel register(RegisterParamsModel paramsModel) throws AccountException {
        UserEntity entity = mUserMapper.selectByUsername(paramsModel.getUsername());
        if (entity != null) {
            throw new AccountException(HttpConstant.HTTP_20003, "帐号已存在");
        }

        if (!RegexUtils.checkMobile(paramsModel.getUsername())) {
            throw new AccountException(HttpConstant.HTTP_20004, "帐号格式不正确, 必须为手机号");
        }

        if (paramsModel.getPassword().length() < 6) {
            throw new AccountException(HttpConstant.HTTP_20005, "密码必须大于等于6位");
        }

        //拼表数据
        UserEntity userEntity = new UserEntity()
                .setUsername(paramsModel.getUsername())
                .setPassword(paramsModel.getPassword())
                .setTel(paramsModel.getUsername())
                .setEmail(paramsModel.getEmail())
                .setId(UUIDUtils.get())
                .setCreateTime(new Date())//更新创建时间
                .setLastLoginTime(new Date())//更新最后更新时间
                .setGender(3);//默认未选为3


        mUserMapper.insert(userEntity);

        //转成返回前端返回值
        return new UserResultModel().setId(userEntity.getId())
                .setEmail(userEntity.getEmail())
                .setTel(userEntity.getTel())
                .setUsername(userEntity.getUsername());

    }
}
