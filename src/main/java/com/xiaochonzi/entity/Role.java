package com.xiaochonzi.entity;

/**
 * Created by stone on 17/6/8.
 */
public class Role {
    private Integer id;
    private String name;
    private Integer permission;
    private Boolean _default;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Boolean get_default() {
        return _default;
    }

    public void set_default(Boolean _default) {
        this._default = _default;
    }
}
