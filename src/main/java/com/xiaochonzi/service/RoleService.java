package com.xiaochonzi.service;

import com.xiaochonzi.entity.Role;

/**
 * Created by stone on 17/6/11.
 */
public interface RoleService {

    Role selectRoleById(int id);

    Role selectRoleByDefault(boolean _default);

}
