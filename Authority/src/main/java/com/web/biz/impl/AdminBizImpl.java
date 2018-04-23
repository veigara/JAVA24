package com.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.AdminBiz;
import com.web.dao.AdminMapper;
import com.web.entity.Admin;

/**
 * 业务逻辑层
 * @author xxq
 *
 */
@Service 
public class AdminBizImpl implements AdminBiz {
	
	@Resource
	AdminMapper adminMapper;

	@Override
	public Admin login(String loginName, String loginPwd) {
		return adminMapper.login(loginName, loginPwd);
	}

}
