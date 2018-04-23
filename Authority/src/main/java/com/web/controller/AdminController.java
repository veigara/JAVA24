package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.AdminBiz;
import com.web.biz.MenuBiz;
import com.web.biz.RoleBiz;
import com.web.entity.Admin;
import com.web.entity.Menu;
import com.web.util.ValidateImage;

/**
 * 控制层
 * @author xxq
 *
 */
@Controller
@RequestMapping(value="") //请求地址
public class AdminController {
	
	@Resource(name="adminBizImpl")//注意：首字母小写
	AdminBiz adminBiz;
	
	@Resource(name="roleBizImpl")
	RoleBiz roleBiz;
	
	@Resource(name="menuBizImpl")
	MenuBiz menuBiz;
	
	/**
	 * 返回类型:String（视图：地址的名称）、void、ModelAndView（模型数据和视图：地址的名称）等
	 * url: login.do
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="login")
	public ModelAndView login(Admin admin,String code,HttpServletRequest req,ModelAndView mv){
		
		//获取session
		HttpSession session = req.getSession();
		
		//获取随机生成的验证码
		String codeValue = session.getAttribute("codeValue").toString();
		
		if(code.equalsIgnoreCase(codeValue)){
			//验证码相同
			
			//调用业务逻辑层的方法
			Admin newAdmin = adminBiz.login(admin.getLoginName(), admin.getLoginPwd());
			
			if(newAdmin != null){
				//登录成功
				
				//把用户信息保存到session中
				session.setAttribute("admin", newAdmin);
				
				//根据角色id查询权限菜单id
				Integer roleId = newAdmin.getRoleId();
				
				List<Integer> owerList = roleBiz.selectAuthority(roleId);
				
				//查询所有的菜单
				List<Menu> allList = menuBiz.findByParentId(0);
				
				//匹配
				List<Menu> list = merge(allList,owerList);
				
				//显示在主页面左边的菜单数据
				mv.addObject("owerMenu", list);
				mv.setViewName("admin/main");// admin/main.jsp   逻辑视图
				
			}else{
				//登录失败
				mv.setViewName("login");
			}
			
		}else{
			//登录失败
			mv.setViewName("login");
		}
		return mv;
	}
	
	/**
	 * 匹配菜单
	 * @param allList
	 * @param owerList
	 * @return
	 */
	public List<Menu> merge(List<Menu> allList,List<Integer> owerList){
		
		List<Menu>  list = new ArrayList<Menu>();
		
		for (Menu m : allList) {
			
			//判断是否有权限
			if(hasAuthority(m.getMenuId(),owerList)){
				
				//递归子节点
				m.setChildMenu(merge(m.getChildMenu(),owerList));
				
				list.add(m);
			}
			
			
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
			if(b == menuId){
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 生成验证码的方法
	 * url:code.do
	 */
	@RequestMapping(value="code")
	public void code(HttpServletRequest req,HttpServletResponse resp){
		
		try {
			//生成图片对象
			ValidateImage img = new ValidateImage(150, 40, 4, 30);
			
			//获取验证码
			String code = img.getRandomCode().toString();
			
			//把验证码保存到session
		    HttpSession session = req.getSession();
		    
		    session.setAttribute("codeValue", code);
		    
		    //响应内容
		    resp.setHeader("Pragme", "no-cache");
		    resp.setHeader("Cache-Control", "no-cache");
		    
		    resp.setDateHeader("Expires", 0);
		    resp.setContentType("image-jpeg");
		    
		    ServletOutputStream sos = resp.getOutputStream();
		    ImageIO.write(img.getImage(), "jpeg", sos);
		    
		    //关闭
		    sos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
