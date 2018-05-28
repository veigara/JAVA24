package com.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CommonDao;

public abstract class CommonDaoImpl<T> implements CommonDao<T> {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean add(T obj){
		try {
			//1.获取session
			Session session = sessionFactory.getCurrentSession();
			
			session.save(obj);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
