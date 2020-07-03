package com.yuhang.novel.pirate.dto.mapper;

import com.yuhang.novel.pirate.dto.entity.UsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 唯一id Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-08-06
 */
public interface UsersMapper extends BaseMapper<UsersEntity> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    UsersEntity selectByUsername(String username);

    /**
     * 更新最后登陆时间
     * @param entity
     */
    void updateLastTimeByPrimaryKey(UsersEntity entity);

    /**
     * 根据id查询
     * @param id 唯一标识
     * @return
     */
    UsersEntity selectByPrimaryKey(String id);

    /**
     * 根据邮箱查找查找用户
     * @param email
     * @return
     */
    UsersEntity selectByEmailAndUsername(String username, String email);

    /**
     * 邮箱指定帐号是否存在
     * @param email
     * @return
     */
    List<UsersEntity> selectByEmail(String email);

    /**
     * 查询是否vip
     * @param uid 用户id
     * @return
     */
    int selectVipByUid(String uid);
}
