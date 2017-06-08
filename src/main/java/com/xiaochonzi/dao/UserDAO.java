package com.xiaochonzi.dao;

import com.xiaochonzi.entity.User;

/**
 * Created by stone on 17/6/8.
 */
public interface UserDAO {

    /**
     * 新增用户
     * @param user
     */
    public int insertUser(User user);

    /**
     * 删除用户
     * 根据id,username,email
     * @param user
     * @return
     */
    public int deleteUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 查询用户
     * 通过id,username,email
     * @param user
     * @return
     */
    public User selectByUser(User user);


}
