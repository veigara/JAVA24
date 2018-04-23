package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.Role;
import com.web.util.PageUtil;

public interface RoleBiz {

	/**
	 * 分页查询
	 * @param paging
	 * @param map
	 */
	public void pagingQuery(PageUtil<Role> paging,Map<String,Object> map);

	/**
     * 根据角色id查询权限菜单id
     * @param roleId
     * @return
     */
    List<Integer> selectAuthority(Integer roleId);
    
    /**
     * 保存权限
     * @param roleId
     * @param menuIds
     * @return
     */
    public boolean saveAuthority(Integer roleId,Integer[] menuIds);
}
