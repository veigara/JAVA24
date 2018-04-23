package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.RoleBiz;
import com.web.dao.RoleMapper;
import com.web.entity.Role;
import com.web.entity.RoleExample;
import com.web.entity.RoleExample.Criteria;
import com.web.util.PageUtil;

@Service
public class RoleBizImpl implements RoleBiz {
	
	@Resource
	RoleMapper roleMapper;

	@Override
	public void pagingQuery(PageUtil<Role> paging, Map<String, Object> map) {
		
		RoleExample example = new RoleExample();
		
		example.setOffset(paging.getExclude());//设置排除多少笔数据
		example.setLimit(paging.getPageSize());//设置最多显示的条数
		
		Criteria c = example.createCriteria();
		
		if(map != null){
			for (String key : map.keySet()) {
				if("roleName".equals(key)){
					c.andRoleNameLike(map.get(key).toString());
				}
			}
		}
		
		//设置分页查询的数据
		paging.setData(roleMapper.selectByExample(example));
		
		long counts = roleMapper.countByExample(example);
		
	    //设置分页查询的总条数
		paging.setTotalCount((int)counts);

	}

	@Override
	public List<Integer> selectAuthority(Integer roleId) {
		
		return roleMapper.selectAuthority(roleId);
	}

	@Override
	public boolean saveAuthority(Integer roleId, Integer[] menuIds) {
		
		//清空数据
		roleMapper.deleteAuthority(roleId);
		
		int counts = 0;
		
		for (Integer nenuId : menuIds) {
			counts += roleMapper.insertAuthority(roleId, nenuId);
		}
		
		return counts > 0 ? true : false;
	}

}
