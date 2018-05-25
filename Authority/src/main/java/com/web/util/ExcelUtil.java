package com.web.util;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.entity.Role;

public class ExcelUtil {


	/**
	 * 创建excel表
	 */
	@SuppressWarnings("deprecation")
	public static void createExcel(List<Role> data,HttpServletResponse resp,String sheetName,String totilName){
		// 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();
        
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet(sheetName); 
        
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);
        
           
      
        
        HSSFCell cellheader = row.createCell(0);
        cellheader.setCellValue(totilName);
        
        
        
      //设置标题和单元格样式
        HSSFCellStyle columnTopStyle = getColumnTopStyle(wb);  //获取列头样式对象
        
//        HSSFCellStyle style = this.getStyle(wb);
        
        //合并单元格//参数说明：1：开始行 2：结束行  3：开始列 4：结束列  
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (data.size() - 1)));
        
        cellheader.setCellStyle(columnTopStyle);
        
        row = sheet.createRow((short)2); //创建Excel工作表的行   
        
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        
        row.createCell(0).setCellValue("角色编号");
        row.createCell(1).setCellValue("角色名称");
        /*cell.setCellValue("角色编号");    
        cell.setCellStyle(style);    
        cell = row1.createCell( 1);    
        cell.setCellValue("角色名称");*/
        
        HSSFCellStyle style1 = wb.createCellStyle(); // 样式对象
//        style1.setFillForegroundColor(HSSFColor.SKY_BLUE.index); 
        style1.setFillBackgroundColor(HSSFColor.BLUE.index);
      //设置底边框;
		 style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 
		//设置底边框颜色;
		 style1.setBottomBorderColor(HSSFColor.BLACK.index);
		 
		//设置左边框;
		 style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 
		 //设置左边框颜色;
		 style1.setLeftBorderColor(HSSFColor.BLACK.index);
		 
		 //设置右边框;
		 style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 
		//设置右边框颜色;
		 style1.setRightBorderColor(HSSFColor.BLACK.index);
		 
		//设置顶边框;
		 style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 
		//设置顶边框颜色;
		 style1.setTopBorderColor(HSSFColor.BLACK.index);
		 
		// 设置字体
	    HSSFFont font = wb.createFont();
	    font.setColor(HSSFColor.RED.index);
		 style1.setFont(font);
        
        for (int i = 0; i < data.size(); i++)    
        {    
            row = sheet.createRow((int) i + 3); //有多少条数据就应该创建多少行   
            Role s = data.get(i);
            
            // 第四步，创建单元格，并设置值   
            
            HSSFCell c1 = row.createCell(0);
          
            c1.setCellValue((double) s.getRoleId()); 
            c1.setCellStyle(columnTopStyle);
            
            HSSFCell c2 = row.createCell(1);
            
            c2.setCellStyle(columnTopStyle);
            c2.setCellValue(s.getRoleName());   
            
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
	 public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
		// 设置字体
		 HSSFFont font = workbook.createFont();
		 
		//设置字体大小
		 font.setFontHeightInPoints((short) 11);
		 
		//字体加粗
		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 
		//设置字体名字
		 font.setFontName("Courier New");
		 
		 font.setColor(HSSFColor.RED.index);
		 
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
	 public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
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
