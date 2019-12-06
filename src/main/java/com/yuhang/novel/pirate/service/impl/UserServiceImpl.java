package com.yuhang.novel.pirate.service.impl;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.dto.entity.AppConfigEntity;
import com.yuhang.novel.pirate.dto.entity.UsersEntity;
import com.yuhang.novel.pirate.dto.mapper.AppConfigMapper;
import com.yuhang.novel.pirate.dto.mapper.UsersMapper;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.AuthorizationInfoModel;
import com.yuhang.novel.pirate.model.ConfigModel;
import com.yuhang.novel.pirate.model.UserModel;
import com.yuhang.novel.pirate.model.params.LoginParams;
import com.yuhang.novel.pirate.model.params.RegisterParams;
import com.yuhang.novel.pirate.model.params.UpdatePasswordParams;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.utils.RegexUtils;
import com.yuhang.novel.pirate.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户信息:
 * 登陆/注册等
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户
     */
    @Resource
    private UsersMapper mUserMapper;

    /**
     * 配置
     */
    @Resource
    private AppConfigMapper mConfigMapper;

    @Override
    public UserModel login(LoginParams paramsModel) throws AccountException {
        UsersEntity entity = mUserMapper.selectByUsername(paramsModel.getUsername());
        if (entity == null) {
            throw new AccountException(HttpConstant.HTTP_20001, "帐号不存在");
        }
        if (!entity.getPassword().equals(paramsModel.getPassword())) {
            throw new AccountException(HttpConstant.HTTP_20002, "密码不正确");
        }
        //更新最后登陆时间
        entity.setLastLoginTime(new Date());
        mUserMapper.updateById(entity);

        return new UserModel().setId(entity.getId())
                .setEmail(entity.getEmail())
                .setTel(entity.getTel())
                .setUsername(entity.getUsername());
    }

    @Override
    public UserModel register(RegisterParams paramsModel) throws AccountException {
        UsersEntity entity = mUserMapper.selectByUsername(paramsModel.getUsername());
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
        UsersEntity userEntity = new UsersEntity()
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
        return new UserModel().setId(userEntity.getId())
                .setEmail(userEntity.getEmail())
                .setTel(userEntity.getTel())
                .setUsername(userEntity.getUsername());

    }

    @Override
    public AuthorizationInfoModel selectByPrimaryKey(String uid) {
        UsersEntity userEntity = mUserMapper.selectByPrimaryKey(uid);

        AuthorizationInfoModel model = new AuthorizationInfoModel();
        if (userEntity != null) {
            model.setUsername(userEntity.getUsername())
                    .setUid(userEntity.getId())
                    .setPassword(userEntity.getPassword());
        }
        return model;
    }

    @Override
    public UserModel updatePassword(UpdatePasswordParams params) throws AccountException {
        UsersEntity entity = mUserMapper.selectByEmailAndUsername(params.getUsername(), params.getEmail());
        if (entity == null) {
            throw new AccountException(HttpConstant.HTTP_20011, "帐号与邮箱不匹配");
        }
        if (!params.getPassword().equals(params.getAgainPassword())) {
            throw new AccountException(HttpConstant.HTTP_20012, "两次密码必须一致");
        }
        if (params.getPassword().length() < 6) {
            throw new AccountException(HttpConstant.HTTP_20005, "密码必须大于等于6位");
        }
        if (!RegexUtils.checkMobile(params.getUsername())) {
            throw new AccountException(HttpConstant.HTTP_20004, "帐号格式不正确, 必须为手机号");
        }

        entity.setPassword(params.getPassword());

        mUserMapper.updateById(entity);

        UserModel userModel = new UserModel().setId(entity.getId())
                .setEmail(entity.getEmail())
                .setTel(entity.getTel())
                .setUsername(entity.getUsername());
        return userModel;
    }

    @Override
    public boolean checkUserEmpty(String email) {
        List<UsersEntity> list = mUserMapper.selectByEmail(email);
        return list != null && !list.isEmpty();
    }

    @Override
    public ConfigModel getConfigModel() {
        AppConfigEntity entity = mConfigMapper.selectEntityByOne();
        ConfigModel model = new ConfigModel();
        model.setShowGameRecommended(entity.getShowGameRecommended() == 1);
        model.setShowSexBook(entity.getShowSexBook() == 1);
        return model;
    }

}
