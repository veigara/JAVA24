package com.web.util;

import java.util.List;

/**
 * 分页工具类
 * 每页显示的条数、页码、查询总的条数（从数据库查询）
 * 、总的页码=总的条数/每页显示的条数、数据（从数据库查询）
 * @author xxq
 *
 */
public class PageUtil<T> {

	private Integer currentPage=1;//当前页码
	private Integer pageSize=2;//每页显示的条数
	private Integer totalCount;//总条数  （需要从数据库查询）
	private Integer totalPage;//总页码 = 总条数  / 每页显示的条数
	private List<T> data;//数据（从数据库查询）
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		this.totalPage = (int)(Math.ceil((this.totalCount * 1.0) / this.pageSize));
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	/**
	 * 判断是否有上一页
	 * @return
	 */
	public boolean isPrev(){
		
		return this.getCurrentPage() > 1 ? true : false;
	}
	
	/**
	 * 判断是否有下一页
	 * @return
	 */
	public boolean isLast(){
		
		return this.getCurrentPage() < this.getTotalPage() ? true : false;
	}
	
	/**
	 * 获取上一页的页码
	 * @return
	 */
	public Integer getPrevPage(){
		
		return isPrev() ? (this.getCurrentPage()-1) : this.getCurrentPage();
	}
	
	/**
	 * 获取下一页的页码
	 * @return
	 */
	public Integer getLastPage(){
		
		return isLast() ?  (this.getCurrentPage()+1) : this.getCurrentPage();
	}
	
	/**
	 *排除前面多少条数据
	 *select  * from t limit ?,?
	 *指的是第一个参数的值
	 * @return
	 */
	public Integer getExclude(){
		
		return (this.getCurrentPage()-1) * this.pageSize;
	}
	
	/**
	 * 获取导航条
	 * @return
	 */
	public String getNavigation(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input id=\"myPage\" type=\"hidden\" name=\"page\">");
		
		sb.append("<div class=\"col-sm-6\">");
		  sb.append("<div class=\"dataTables_paginate paging_simple_numbers\" id=\"dataTables-example_paginate\">");
		     sb.append("<ul class=\"pagination\">");
		     
		       //判断是否有上一页
		       if(isPrev()){
		    	   //有上一页
		    	   sb.append("<li class=\"paginate_button previous\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_previous\">");
		    	     sb.append(" <a pdata="+(this.getCurrentPage()-1)+" href=\"javascript:void(0);\">Previous</a>");
		    	   sb.append("</li>");
		       }else{
		    	   //没有上一页
		    	  sb.append("<li class=\"paginate_button previous disabled\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_previous\">");
		    	    sb.append("<a  pdata=\"1\" href=\"javascript:void(0);\">Previous</a>");
		    	  sb.append("</li>");
		       }
		     
		       //显示中间的页码数
		       int start =1;
			   int end = this.getTotalPage();
				
				if(this.getCurrentPage() -5 >=0){
					start = this.getCurrentPage()-5;
					end = start+5;
					
					if(end > this.getTotalPage()){
						end = this.getTotalPage();
						start = end-5;
						
						if(start < 1){
							start = 1;
						}
					}
				}
				
		       for(int i = start;i <= end; i++){
		    	   if(this.currentPage == i){
		    		   sb.append("<li class=\"paginate_button active\" aria-controls=\"dataTables-example\" tabindex=\"0\">");
		    		      sb.append("<a pdata="+i+" href=\"javascript:void(0);\">"+i+"</a>");
		    		   sb.append("</li>");
		    	   }else{
		    		   sb.append("<li class=\"paginate_button\" aria-controls=\"dataTables-example\" tabindex=\"0\">");
		    		      sb.append("<a pdata="+i+" href=\"javascript:void(0);\">"+i+"</a>");
		    		   sb.append("</li>");
		    	   }
		       }
		       
		       //下一页
		       if(isLast()){
		    	   //有下一页
		    	   sb.append("<li class=\"paginate_button next\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_next\">");
		    	     sb.append("<a pdata="+(this.getCurrentPage()+1)+" href=\"javascript:void(0);\">Next</a>");
		    	   sb.append("</li>");
		       }else{
		    	   //没有下一页
		    	   sb.append("<li class=\"paginate_button next disabled\" aria-controls=\"dataTables-example\" tabindex=\"0\" id=\"dataTables-example_next\">");
		    	     sb.append("<a pdata="+this.getTotalPage()+" href=\"javascript:void(0);\">Next</a>");
		    	   sb.append("</li>");
		       }
		       
		     sb.append("</ul>");
		  sb.append("</div>");
		sb.append("</div>");
		
		return sb.toString();
		
	}
	
}
