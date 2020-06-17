package com.yuhang.novel.pirate.shiro;

import com.yuhang.novel.pirate.constant.HttpConstant;
import com.yuhang.novel.pirate.exception.AccountException;
import com.yuhang.novel.pirate.model.AuthorizationInfoModel;
import com.yuhang.novel.pirate.service.UserService;
import com.yuhang.novel.pirate.utils.JwtUtil;
import com.yuhang.novel.pirate.utils.TokenUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:07
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService mUserService;


    /**
     * 必须重写此方法，不然shiro会报错
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = JwtUtil.getUsername(principals.toString());
//        AuthorizationInfoModel user = mUserService.selectByPrimaryKey(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户名查询权限 TODO 放到redis中
//        List roles = new ArrayList();
//        roles.parallelStream().forEach(role ->{
//            info.addStringPermission("");
//        });
        return info;
    }

    /**
     * 认证
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getPrincipal();
        if (StringUtils.isEmpty(token)) {
            throw new AccountException(HttpConstant.HTTP_20006, "Token 不能为空");
        }
        String uid = JwtUtil.getUid(token);
        if (StringUtils.isEmpty(uid)) {
            throw new IncorrectCredentialsException("用户名无效");
        }

        AuthorizationInfoModel user = mUserService.selectByPrimaryKey(uid);
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }

        if(!JwtUtil.verify(token,uid, TokenUtils.getSecret(user.getPassword()))){
            throw new AccountException(HttpConstant.HTTP_20005, "密码错误");
        }

        return new SimpleAuthenticationInfo(token, token, getName());
    }


}