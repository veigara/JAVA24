package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class MenuRoleKey implements Serializable {
    /**
     * 菜单id  外键
     */
    private Integer menuId;

    /**
     * 角色id  外键
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}