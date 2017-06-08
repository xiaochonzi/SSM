package com.xiaochonzi.dao;

import com.xiaochonzi.entity.Role;

/**
 * Created by stone on 17/6/8.
 */
public interface RoleDAO {

    /**
     * 查找角色
     * @param role
     * @return
     */
    public Role selectByRole(Role role);
}
