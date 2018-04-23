package com.web.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.MenuBiz;
import com.web.dao.MenuMapper;
import com.web.entity.Menu;

@Service
public class MenuBizImpl implements MenuBiz {
	
	@Resource
	MenuMapper menuMapper;

	@Override
	public List<Menu> findByParentId(Integer parentId) {
		
		//查询第一层的菜单集合
		List<Menu> list = cursion(parentId);
		
		return list;
	}

	/**
	 * 递归
	 */
	public List<Menu> cursion(Integer parentId){
		
		List<Menu> list = new ArrayList<Menu>();
		
		List<Menu> oneList = menuMapper.findByParentId(parentId);
		
		for (Menu menu : oneList) {
			//得到第二层菜单的父级节点
			Integer twoParentId = menu.getMenuId();
			
			//查询第二层的菜单集合
			List<Menu> twoList = menuMapper.findByParentId(twoParentId);
			
			menu.setChildMenu(twoList);
			
			cursion(twoParentId);
			
			list.add(menu);
		}
		return list;
	}

	@Override
	public int insertSelective(Menu menu) {
		return menuMapper.insert(menu);
	}

	@Override
	public Menu selectByPrimaryKey(Integer menuId) {
		return menuMapper.selectByPrimaryKey(menuId);
	}
	
	
	
	
}
