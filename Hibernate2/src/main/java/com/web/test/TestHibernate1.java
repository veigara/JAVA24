package com.web.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.web.entity.Computers;
import com.web.util.HibernateUtil;

public class TestHibernate1 {

	@Test
	public void testAuto() throws Exception {
		//1.读取配置文件
		Configuration cfg = new Configuration().configure();
		
		//2.操作  添加
		//获取session工厂
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
		               .applySettings(cfg.getProperties()).build();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory(sr);
		
		//获取session对象
		Session session = sessionFactory.getCurrentSession();
		
		//开启事务
		Transaction trans = session.beginTransaction();
		
		//执行操作
		
		//瞬时状态
		Computers c = new Computers();
		c.setCname("华硕5");
		c.setCsize(15);
		c.setCdate(new Date());
		
		//持久化操作
		
		//持久化状态
		session.save(c);
		
		//持久化状态
//		c.setCname("戴尔");
		
		//事务的提交
		trans.commit();
		
		//离线状态
		c.setCname("苹果");
	}
	
	@Test
	public void testGet() throws Exception {
		
		Session session = null;
		Transaction trans = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			Computers c = (Computers) session.get(Computers.class, 0);
			
			System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		}
	}
	
	@Test
	public void testLoad() throws Exception {
		Session session = null;
		Transaction trans = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			Computers c = (Computers) session.load(Computers.class, 0);
			
			System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Session session = null;
		Transaction trans = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			 Computers c = new Computers();
			 c.setCid(1);
			 c.setCname("弘基");
			 c.setCsize(20);
			 c.setCdate(new Date());
		
			session.update(c);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		}
	}
	
	@Test
	public void testDelete() throws Exception {
		Session session = null;
		Transaction trans = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			Computers c = (Computers) session.get(Computers.class, 7);
		
			session.delete(c);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		}
	}
	
	@Test
	public void testQuery() throws Exception {
		// sql ： struct query language  查询表
		//hql: hibernate query language   查询对象
		Session  session = null;
		Transaction trans = null;
		Query query = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			 //sql : select * from t_computers
			 String hql = "from Computers";
			 
			 query = session.createQuery(hql);
			
			 List<Computers> list =  query.list();
			 
			 for (Computers c : list) {
				System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		} 
	}
	
	@Test
	public void testQueryByCondition() throws Exception {
		// sql ： struct query language  查询表
		//hql: hibernate query language   查询对象
		Session  session = null;
		Transaction trans = null;
		Query query = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			 //sql : select * from t_computers where cname like '%华%' and csize=14
			 String hql = "from Computers where cname like ? "
			 		+ "and csize=?";
			 
			 query = session.createQuery(hql);
			 
			 //传参数
			 query.setParameter(0, "%华%");
			 query.setParameter(1, 15);
			
			 List<Computers> list =  query.list();
			 
			 for (Computers c : list) {
				System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		} 
	}
	
	@Test
	public void testPagingQuery() throws Exception {
		// sql ： struct query language  查询表
		//hql: hibernate query language   查询对象
		Session  session = null;
		Transaction trans = null;
		Query query = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			 //sql : select * from t_computers where cname like '%华%' and csize=14
			 String hql = "from Computers where cname like ? "
			 		+ "and csize=?";
			 
			 query = session.createQuery(hql);
			 
			 //传参数
			 query.setParameter(0, "%华%");
			 query.setParameter(1, 15);
			 
			 query.setFirstResult(2);//排除前面多少笔数据
			 query.setMaxResults(2);//设置每页最多显示多少条数据
			
			 List<Computers> list =  query.list();
			 
			 for (Computers c : list) {
				System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		} 
	}
	
	
	
	
	
	
	
	
}
