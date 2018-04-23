package com.web.biz;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Admin;

public interface AdminBiz {

	  Admin login(@Param("loginName") String loginName,@Param("loginPwd") String loginPwd);
}
