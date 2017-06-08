package com.xiaochonzi.dao;

import com.xiaochonzi.entity.Post;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.entity.UserDetail;

import java.util.List;

/**
 * Created by stone on 17/6/8.
 */
public interface UserDetailDAO {

    /**
     * 新增个人信息详情
     * @param userDetail
     * @return
     */
    public int inserUserDetail(UserDetail userDetail);

    /**
     * 删除个人信息详情
     * 通过id
     * @param id
     * @return
     */
    public int deleteUserDetailById(int id);

    /**
     * 更新个人信息详情
     * @param userDetail
     * @return
     */
    public int updateUserDetail(UserDetail userDetail);

    /**
     * 查找个人信息详情
     * 通过id
     * @param id
     * @return
     */
    public int selectUserDetailById(int id);

    /**
     * 查找我关注的人总数
     * @param id
     * @return
     */
    public int countFllowers(int id);

    /**
     * 查找我关注的人
     * @param id
     * @return
     */
    public List<User> selectFollowers(int id);

    /**
     * 查找关注我的人总数
     * @param id
     * @return
     */
    public int countFans(int id);

    /**
     * 查找关注我的人
     * @param id
     * @return
     */
    public List<User> selectFans(int id);

}
