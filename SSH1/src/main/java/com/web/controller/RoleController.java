package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.biz.RoleBiz;
import com.web.entity.Role;
import com.web.pojo.EasyuiResult;
import com.web.pojo.OptioResult;
import com.web.util.PageUtil;
import com.web.util.StringUtil;

@Controller
@Namespace("")
@ParentPackage("json-default")
public class RoleController extends ActionSupport implements ModelDriven<Role>{
	
	@Resource(name="roleBizImpl")
	RoleBiz roleBiz;
	
	Role role = new Role();
	
	OptioResult optionResult = new OptioResult();
	
	EasyuiResult<Role> easyuiResult = new EasyuiResult();
	
	private Integer page;//接收easyui界面传过来的页码
	private Integer rows;//接收easyui界面传过来的每页显示的条数
	
	@Override
	public Role getModel() {
		return role;
	}

	
	@Action(value="addRole",results={@Result(name="success",type="json"
			,params={"root","optionResult"})})
	public String add() throws Exception {
		
		boolean flag = roleBiz.add(role);
		
		optionResult.setFlag(flag);
		optionResult.setMessage(flag ? "添加成功!" : "添加失败！");
		
		return flag ? SUCCESS : INPUT;
	}
	
	
	@Action(value="queryRole",results={@Result(name="success",type="json",
			params={"root","easyuiResult"})})
	public String query() throws Exception{
		
		PageUtil<Role> paging = new PageUtil<>();
		
		paging.setCurrentPage(page);//设置分页的当前页码
		paging.setPageSize(rows);//设置分页每页显示的条数
		
		Map<String,Object> maps = new HashMap<>();
		
		if(StringUtil.isNotEmpty(role.getRoleName())){
			maps.put("roleName", "%"+role.getRoleName()+"%");
		}
		
		roleBiz.pagingQuery(paging, maps);
		
		//设置分页查询的总条数 和  数据
		easyuiResult.setTotal(paging.getTotalCount());
		easyuiResult.setRows(paging.getData());
		
		return SUCCESS;
	}


	public OptioResult getOptionResult() {
		return optionResult;
	}


	public void setOptionResult(OptioResult optionResult) {
		this.optionResult = optionResult;
	}


	public EasyuiResult<Role> getEasyuiResult() {
		return easyuiResult;
	}


	public void setEasyuiResult(EasyuiResult<Role> easyuiResult) {
		this.easyuiResult = easyuiResult;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}

	
}
