package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Role implements Serializable {
    /**
     * 主键
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}