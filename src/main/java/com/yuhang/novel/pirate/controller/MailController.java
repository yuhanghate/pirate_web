package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.exception.MailException;
import com.yuhang.novel.pirate.model.UserModel;
import com.yuhang.novel.pirate.model.params.CheckEmailCodeParams;
import com.yuhang.novel.pirate.model.params.LoginParams;
import com.yuhang.novel.pirate.model.params.UpdatePasswordParams;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.model.result.MailCodeResult;
import com.yuhang.novel.pirate.model.result.UserResult;
import com.yuhang.novel.pirate.service.MailService;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.shiro.JwtToken;
import com.yuhang.novel.pirate.utils.CodeUtils;
import com.yuhang.novel.pirate.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/m/email")
@Api(value = "邮箱模块", description = "提供邮箱相关的api接口", tags = "邮箱api接口")
public class MailController {

    @Resource
    MailService mMailService;

    @Resource
    UserService mUserService;

    @GetMapping("/code/send")
    @ApiOperation(value = "发送验证码", notes = "发送验证码")
    public BaseResult sendEmailCode(@ApiParam(value = "邮箱", required = true)@RequestParam String mail) {

        String validationCode4 = CodeUtils.getValidationCode4();
        String content = "验证码：" + validationCode4 + "，请保密并确认本人操作。\n" +
                "如果不是您本人操作，请忽略本邮件。\n" +
                "\n" +
                "注：自动发送邮件，请勿直接回复，如果有问题请发邮件到开发者服务邮箱：yh714610354@gmail.com 进行咨询。";
        try {
            mMailService.sendTextMail(mail, "【随便看书】验证码", content);
            return new MailCodeResult().setData(validationCode4);
        } catch (MailException e) {
            e.printStackTrace();
            return new BaseResult(e.getErrorCode(), e.getErrorMsg());
        }
    }

    @PostMapping(value = "/code/check", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "验证码验证", notes = "验证码验证")
    public BaseResult checkEmailCode(@RequestBody CheckEmailCodeParams params) {
        if (!StringUtils.isEmpty(params.getOldCode()) && params.getOldCode().length() == 4 && params.getOldCode().equals(params.getNewCode())) {
            return new BaseResult();
        }
        return new BaseResult().setCode(HttpConstant.HTTP_20010).setMsg("邮箱验证码不正确");
    }

    @GetMapping(value = "/user/check")
    @ApiOperation(value = "检测邮箱是否存在", notes = "检测邮箱是否存在")
    public BaseResult checkEmailUserEmpty(@ApiParam(value = "邮箱", required = true) @RequestParam String email) {
        boolean check = mUserService.checkUserEmpty(email);
        if (check) {
            return new BaseResult();
        } else {
            return new BaseResult().setCode(HttpConstant.HTTP_20001).setMsg("帐号不存在");
        }
    }

    @PostMapping(value = "/update/password", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "修改密码", notes = "修改密码")
    public UserResult updatePassword(@RequestBody UpdatePasswordParams params) {

        try {

            UserModel userModel = mUserService.updatePassword(params);
            LoginParams loginParams = new LoginParams();
            loginParams.setUsername(userModel.getUsername());
            loginParams.setPassword(params.getPassword());
            UserModel resultModel = mUserService.login(loginParams);
            JwtToken token = TokenUtils.init(resultModel.getId(), loginParams.getPassword());
            SecurityUtils.getSubject().login(token);
            resultModel.setToken(token.getPrincipal().toString());
            return (UserResult) new UserResult().setData(resultModel).setCode(HttpConstant.HTTP_200).setMsg("密码修改成功");
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
