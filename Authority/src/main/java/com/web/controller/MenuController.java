package com.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.MenuBiz;
import com.web.entity.Menu;
import com.web.pojo.TreePojo;
import com.web.util.StringUtil;


@Controller
@Scope(value="prototype")
@RequestMapping(value="admin/")
public class MenuController {
	
	@Resource(name="menuBizImpl")//注意：首字母小写
	MenuBiz menuBiz;
	
	
	/**
	 * 跳转到添加页面
	 * url：http://localhost:8080/Authority/admin/sendAddMenu.do
	 * @return
	 */
	@RequestMapping(value="sendAddMenu")
	public ModelAndView sendAddMenu(ModelAndView mv){
		
//		ModelAndView mv = new ModelAndView();
		
		//根据父级id查询菜单信息
		List<Menu> list = menuBiz.findByParentId(0);
		
		//设置数据
		mv.addObject("list", list);
		mv.setViewName("menu/addMenu");//逻辑视图名称    admin/menu/addMenu.jsp
	
		return mv;
	}

	/**
	 * 添加
	 * url：http://localhost:8080/Authority/admin/addMenu.do
	 * @return
	 */
	@RequestMapping(value="addMenu")
	public ModelAndView addMenu(Menu menu,ModelAndView mv){
		
		///Authority/attached/image/20180411/20180411104215_195.jpg
		
		System.out.println("菜单名称:"+menu.getMenuName());
		
		//获取父级菜单对象
		Menu parentMenu = menuBiz.selectByPrimaryKey(menu.getParentId());
		
		menu.setMenuClick(0);
		menu.setMenuImage(StringUtil.getImageUrl(menu.getMenuImage()));
		
		if(menu.getParentId() == 0){
			menu.setMenuLevel(1);
		}else{
			//菜单层级为父级菜单的层级+1
			menu.setMenuLevel(parentMenu.getMenuLevel() + 1);
		}
		menu.setMenuState(1);
		menu.setMenuTime(new Date());
		
		//调用添加方法
		int count = menuBiz.insertSelective(menu);
		
		mv.setViewName(count != 0 ? "menu/listMenu" : "menu/addMenu");// admin/menu/listMenu.jsp
		
		return mv;
	}
	
	
	@RequestMapping(value="getMenuTree")
	@ResponseBody
	public List<TreePojo> getMenuTree(){
		
		List<Menu> list = menuBiz.findByParentId(0);
		
		return mergeTree(list);
	}
	
	/**
	 * 合并
	 * @return
	 */
	public List<TreePojo> mergeTree(List<Menu> list){
		
		List<TreePojo> treeList = new ArrayList<>();
		
		for (Menu menu : list) {
			TreePojo tp = new TreePojo();
			tp.setId(menu.getMenuId());
			tp.setName(menu.getMenuName());
			tp.setpId(menu.getParentId());
			tp.setUrl(menu.getMenuUrl());
			tp.setIcon(menu.getMenuImage());
			
			//递归
			tp.setChildren(mergeTree(menu.getChildMenu()));
			
			treeList.add(tp);
		}
		
		return treeList;
	}
	
	
	
	
	
	
	
}