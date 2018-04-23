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
		 createExcel(data,resp);
	}
	
	/**
	 * 创建excel表
	 */
	@SuppressWarnings("deprecation")
	public void createExcel(List<Role> data,HttpServletResponse resp){
		// 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("角色表"); 
        
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);
        
        HSSFCell cellheader = row.createCell(0);
        cellheader.setCellValue("角色信息");
        
      //设置标题和单元格样式
        HSSFCellStyle columnTopStyle = this.getColumnTopStyle(wb);  //获取列头样式对象
        
//        HSSFCellStyle style = this.getStyle(wb);
        
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (data.size() - 1)));
        
        cellheader.setCellStyle(columnTopStyle);
        
        row = sheet.createRow((int) 2); 
        
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    

        
        HSSFCell cell = row.createCell((short) 0);    
        cell.setCellValue("角色编号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 1);    
        cell.setCellValue("角色名称");
        
        for (int i = 0; i < data.size(); i++)    
        {    
            row = sheet.createRow((int) i + 1); //有多少条数据就应该创建多少行   
            Role s = data.get(i);
            
            // 第四步，创建单元格，并设置值    
            row.createCell((short) 0).setCellValue((double) s.getRoleId());    
            row.createCell((short) 1).setCellValue(s.getRoleName());    
         }
        
        
       // 第六步，下载excel  
        OutputStream out = null;    
        try {        
            out = resp.getOutputStream();//获取输出流   
            String fileName = "role.xls";// 文件名    
            resp.setContentType("application/x-msdownload");    
            resp.setHeader("Content-Disposition", "attachment; filename="    
                                                    + URLEncoder.encode(fileName, "UTF-8"));    
            wb.write(out);    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {      
            try {       
                out.close();      
            } catch (IOException e) {      
                e.printStackTrace();    
            }      
        }     

	}
	
	/**
	 * 标题行的单元格样式
	 * @param workbook
	 * @return
	 */
	 public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
		// 设置字体
		 HSSFFont font = workbook.createFont();
		 
		//设置字体大小
		 font.setFontHeightInPoints((short) 11);
		 
		//字体加粗
		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 
		//设置字体名字
		 font.setFontName("Courier New");
		 
		//设置样式;
		 HSSFCellStyle style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		 
		//设置底边框;
		 style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 
		//设置底边框颜色;
		 style.setBottomBorderColor(HSSFColor.BLACK.index);
		 
		//设置左边框;
		 style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 
		 //设置左边框颜色;
		 style.setLeftBorderColor(HSSFColor.BLACK.index);
		 
		 //设置右边框;
		 style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 
		//设置右边框颜色;
		 style.setRightBorderColor(HSSFColor.BLACK.index);
		 
		//设置顶边框;
		 style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 
		//设置顶边框颜色;
		 style.setTopBorderColor(HSSFColor.BLACK.index);
		 
		//在样式用应用设置的字体;
		 style.setFont(font);
		 
		//设置自动换行;
		 style.setWrapText(false);
		 
		//设置水平对齐的样式为居中对齐;
		 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 
		//设置垂直对齐的样式为居中对齐;
		 style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		 
		 return style;
		 
	 }
	 
	 /**
	  * 设置列的样式	
	  * @param workbook
	  * @return
	  */
	 public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// 设置字体
		 HSSFFont font = workbook.createFont();
		 
		//设置字体大小
		//font.setFontHeightInPoints((short)10);
		 
		 //设置字体名字
		 font.setFontName("Courier New");
		 
		//设置样式;
		 HSSFCellStyle style = workbook.createCellStyle();
		 
		//设置底边框;
		 style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 
		//设置底边框颜色;
		 style.setBottomBorderColor(HSSFColor.BLACK.index);
		 
		 return style;
		 
	 }
}
