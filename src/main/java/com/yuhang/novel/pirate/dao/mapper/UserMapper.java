package com.yuhang.novel.pirate.dao.mapper;

import com.yuhang.novel.pirate.dao.entity.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
public interface UserMapper {

    /**
     * 删除指定id帐号
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入帐号数据
     * @param record
     * @return
     */
    int insert(UserEntity record);

    /**
     * 根据帐号查询帐号
     * @param username
     * @return
     */
    UserEntity selectByUsername(String username);

    /**
     * 根据id查询帐号
     * @param id
     * @return
     */
    UserEntity selectByPrimaryKey(String id);

    /**
     * 查询所有帐号
     * @return
     */
    List<UserEntity> selectAll();

    /**
     * 更新帐号
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserEntity record);

    /**
     * 更新最后登陆时间
     * @return
     */
    int updateLastTimeByPrimaryKey(UserEntity record);
}
