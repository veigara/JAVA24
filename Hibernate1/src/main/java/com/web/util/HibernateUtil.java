package com.web.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * 获取session工厂的工具类
 * @author Administrator
 *
 */
public class HibernateUtil {
	
	static SessionFactory sessionFactory = null;
	static Session session = null;

	static{
		//1.读取配置文件
		Configuration cfg = new Configuration().configure();
		
		//获取session工厂
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
		               .applySettings(cfg.getProperties()).build();
		
		sessionFactory = cfg.buildSessionFactory(sr);
	}
	
	/**
	 * 获取session对象
	 * @return
	 */
	public static Session getSession(){
		session = sessionFactory.getCurrentSession();
		
		return session;
	}
}
