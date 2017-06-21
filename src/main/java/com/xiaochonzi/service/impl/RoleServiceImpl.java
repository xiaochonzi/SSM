package com.xiaochonzi.service.impl;

import com.xiaochonzi.dao.RoleDAO;
import com.xiaochonzi.entity.Role;
import com.xiaochonzi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by stone on 17/6/11.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("roleDAO")
    private RoleDAO roleDAO;


    public Role selectRoleById(int id) {
        return roleDAO.selectRoleById(id);
    }

    public Role selectRoleByDefault(boolean _default) {
        return roleDAO.selectByDefault(_default);
    }
}
