package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.UserModel;
import com.yuhang.novel.pirate.model.params.LoginParams;
import com.yuhang.novel.pirate.model.params.RegisterParams;
import com.yuhang.novel.pirate.model.result.UserResult;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.shiro.JwtToken;
import com.yuhang.novel.pirate.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/m/user")
@Api(value = "用户信息模块", description = "提供用户相关的api接口", tags = "用户api接口")
public class UserController extends BaseController {

    @Resource
    private UserService mUserService;


    @Autowired
    private HttpServletRequest request;

    @ApiOperation(value = "帐号登陆", notes = "登陆接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/login")
    public UserResult login(@RequestBody LoginParams paramsModel) {

        try {

            UserModel resultModel = mUserService.login(paramsModel);
            JwtToken token = TokenUtils.init(resultModel.getId(), paramsModel.getPassword());
            SecurityUtils.getSubject().login(token);
            resultModel.setToken(token.getPrincipal().toString());
            return (UserResult) new UserResult().setData(resultModel).setCode(HttpConstant.HTTP_200).setMsg("登陆成功");
        } catch (UnknownAccountException ex) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_20001).setMsg("用户不存在！");
        } catch (IncorrectCredentialsException ex) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_20004).setMsg("用户名无效！");
        } catch (AccountException e) {
            return (UserResult) new UserResult().setCode(e.getErrorCode()).setMsg(e.getErrorMsg());
        } catch (Exception e) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_30000).setMsg("未知异常");
        }
    }

    @ApiOperation(value = "帐户注册", notes = "注册接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/register")
    public UserResult register(@RequestBody RegisterParams paramsModel) {

        try {

            UserModel resultModel = mUserService.register(paramsModel);
            JwtToken token = TokenUtils.init(resultModel.getId(), paramsModel.getPassword());
            SecurityUtils.getSubject().login(token);
            resultModel.setToken(token.getPrincipal().toString());
            return (UserResult) new UserResult().setData(resultModel).setCode(HttpConstant.HTTP_200).setMsg("注册成功");
        } catch (UnknownAccountException ex) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_20001).setMsg("用户不存在！");
        } catch (IncorrectCredentialsException ex) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_20004).setMsg("用户名无效！");
        } catch (AccountException e) {
            return (UserResult) new UserResult().setCode(e.getErrorCode()).setMsg(e.getErrorMsg());
        } catch (Exception e) {
            return (UserResult) new UserResult().setCode(HttpConstant.HTTP_30000).setMsg("未知异常");
        }
    }


}
