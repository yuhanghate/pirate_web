package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.dao.entity.UserEntity;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.LoginParamsModel;
import com.yuhang.novel.pirate.model.RegisterParamsModel;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/m/user")
@Api(value = "用户信息模块", description = "提供用户相关的api接口", tags = "用户api接口")
public class UserController {
    @Resource
    private UserService mUserService;

    @ApiOperation(value = "帐号登陆", notes = "登陆接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginParamsModel paramsModel) {

        try {
            return ResultUtils.toMap(mUserService.login(paramsModel));
        } catch (AccountException e) {
            e.printStackTrace();
            return ResultUtils.toMap(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @ApiOperation(value = "帐户注册", notes = "注册接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterParamsModel paramsModel) {
        try {
            return ResultUtils.toMap(mUserService.register(paramsModel));
        } catch (AccountException e) {
            e.printStackTrace();
            return ResultUtils.toMap(e.getErrorCode(), e.getErrorMsg());
        }
    }
}
