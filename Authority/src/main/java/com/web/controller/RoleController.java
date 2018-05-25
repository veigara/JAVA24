package com.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.MenuBiz;
import com.web.biz.RoleBiz;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.pojo.MenuPojo;
import com.web.util.ExcelUtil;
import com.web.util.PageUtil;
import com.web.util.StringUtil;

@Controller
@Scope(value="prototype")
@RequestMapping(value="admin/")
public class RoleController {
	
	@Resource(name="roleBizImpl")
	RoleBiz roleBiz;
	
	@Resource(name="menuBizImpl")
	MenuBiz menuBiz;

	/**
	 * 分页查询角色信息
	 * admin/pagingRole.do
	 * @return
	 */
	@RequestMapping(value="pagingRole")
	public ModelAndView pagingQuery(Integer page,ModelAndView mv,Role role){
		
		PageUtil<Role> paging = new PageUtil<>();
		
		if(page != null){
			//设置当前页码
			paging.setCurrentPage(page);
		}
		
		Map<String, Object> map = new HashMap<>();
		
		if(StringUtil.isNotEmpty(role.getRoleName())){
			map.put("roleName", "%"+role.getRoleName()+"%");
		}
		
		//调用业务逻辑层的分页方法
		roleBiz.pagingQuery(paging, map);
		
		//传数据
		mv.addObject("paging", paging);
		mv.addObject("roleName", role.getRoleName());
		
		mv.setViewName("role/list");///  admin/role/list.jsp
		
		return mv;
	}
	
	/**
	 * 跳转到分配权限页面
	 * admin/sendAuthority.do
	 * @return
	 */
	@RequestMapping(value="sendAuthority")
	public ModelAndView sendAuthority(Integer roleId,ModelAndView mv){
		
		//查询所有的菜单信息
		List<Menu> allMenu = menuBiz.findByParentId(0);
		
		//根据角色id查询拥有权限的菜单id
		List<Integer> owerList = roleBiz.selectAuthority(roleId);
		
		//匹配权限
		List<MenuPojo> list = merge(allMenu,owerList);
		
		mv.addObject("list", list);
		mv.addObject("roleId", roleId);
		mv.setViewName("role/authority");// admin/role/authority.jsp
		
		return mv;
	}
	
	/**
	 * 匹配权限
	 * owerList: [1,2]
	 * @param allMenu
	 * @param owerList
	 * @return
	 */
	public List<MenuPojo> merge(List<Menu> allMenu,List<Integer> owerList){
		
		List<MenuPojo> list = new ArrayList<MenuPojo>();
		
		//循环菜单集合
		for (Menu menu : allMenu) {
			MenuPojo mp = new MenuPojo();
			
			if(hasAuthority(menu.getMenuId(), owerList)){
				//有权限
				mp.setAuthority(true);
			}else{
				mp.setAuthority(false);
			}
			
			//递归
			mp.setChildMenu(merge(menu.getChildMenu(),owerList));
			
			mp.setMenuClick(menu.getMenuClick());
			mp.setMenud1(menu.getMenud1());
			mp.setMenuId(menu.getMenuId());
			mp.setMenuImage(menu.getMenuImage());
			mp.setMenuLevel(menu.getMenuLevel());
			mp.setMenuName(menu.getMenuName());
			mp.setMenuOrder(menu.getMenuOrder());
			mp.setMenuState(menu.getMenuState());
			mp.setMenuTime(menu.getMenuTime());
			mp.setMenuUrl(menu.getMenuUrl());
			mp.setParentId(menu.getParentId());
			
			list.add(mp);
		}
		
		return list;
	}
	
	
	/**
	 * 判断是否有权限
	 * @return
	 */
	public boolean hasAuthority(Integer menuId,List<Integer> owerList){
		
		boolean flag = false;
		
		for (Integer b : owerList) {
			if(menuId == b){
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 保存权限
	 * admin/saveAuthority.do
	 * @return
	 */
	@RequestMapping(value="saveAuthority")
	public ModelAndView saveAuthority(Integer roleId,Integer[] accesse,ModelAndView mv){
		
		//调用业务逻辑层的方法
		boolean flag = roleBiz.saveAuthority(roleId, accesse);
		
		mv.setViewName(flag ? "redirect:pagingRole.do" : "redirect:sendAuthority.do?roleId="+roleId);
		
		return mv;
	}
	
	/**
	 * 导出excel
	 * url:admin/excelRole.do
	 */
	@RequestMapping(path="excelRole")
	public void downloadExcel(HttpServletResponse resp){
		PageUtil<Role> paging = new PageUtil<>();
		paging.setPageSize(2000);
		
		//分页查询
		roleBiz.pagingQuery(paging, null);
		
		//导出excel表中的数据
		 List<Role> data = paging.getData();
		 
		 //excel表的导出
		 ExcelUtil.createExcel(data,resp,"角色表","角色信息");
	}
	
}
