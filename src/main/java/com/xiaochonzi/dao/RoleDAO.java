package com.xiaochonzi.dao;

import com.xiaochonzi.entity.Role;

/**
 * Created by stone on 17/6/8.
 */
public interface RoleDAO {

    /**
     * 查找角色
     * @param id
     * @return
     */
    public Role selectRoleById(int id);

    /**
     * 查找角色
     * @param _default
     * @return
     */
    public Role selectByDefault(boolean _default);
}
