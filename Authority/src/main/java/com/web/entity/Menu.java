package com.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Menu implements Serializable {
    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 访问地址
     */
    private String menuUrl;

    /**
     * 菜单图标
     */
    private String menuImage;

    /**
     * 菜单排序
     */
    private Integer menuOrder;

    /**
     * 是否显示  1：显示  0：不显示
     */
    private Integer menuState;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 点击率
     */
    private Integer menuClick;

    /**
     * 创建时间
     */
    private Date menuTime;

    /**
     * 菜单层级
     */
    private Integer menuLevel;

    /**
     * 预留字段
     */
    private String menud1;
    
    /**
     * 子菜单
     */
    private List<Menu> childMenu;

    private static final long serialVersionUID = 1L;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getMenuState() {
        return menuState;
    }

    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuClick() {
        return menuClick;
    }

    public void setMenuClick(Integer menuClick) {
        this.menuClick = menuClick;
    }

    public Date getMenuTime() {
        return menuTime;
    }

    public void setMenuTime(Date menuTime) {
        this.menuTime = menuTime;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenud1() {
        return menud1;
    }

    public void setMenud1(String menud1) {
        this.menud1 = menud1;
    }

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}
    
    
}