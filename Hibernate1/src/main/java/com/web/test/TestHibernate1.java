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
	/**
	 * 插入数据
	 * @throws Exception
	 */
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
		c.setCname("华硕");
		c.setCsize(15);
		c.setCdate(new Date());
		
		//持久化操作
		
		//持久化状态
		session.save(c);//插入数据
		
	
		//事务的提交
		trans.commit();
		
		//离线状态
		c.setCname("苹果");
	}
	
	@Test
	/**
	 * get（）根据id主键查询，不具有延迟性
	 * @throws Exception
	 */
	public void testGet() throws Exception {
		
		Session session = null;
		Transaction trans = null;
		
		try {
			//1.获取session
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//3.持久化操作
			Computers c = (Computers) session.get(Computers.class, 1);
			
			System.out.println("电脑名称:"+c.getCname()+",编号:"+c.getCid());
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();//回滚事务
		}
	}
	
	@Test
	/**
	 * load（）根据id主键查询，具有延迟性
	 * @throws Exception
	 */
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
	/**
	 * 更新
	 * @throws Exception
	 */
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
	/**
	 * 删除
	 * @throws Exception
	 */
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
	/**
	 * 查询
	 * @throws Exception
	 */
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
			 String hql = "from Computers";//注该Computers为实体类，不是数据库中的表
			 
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
	/**
	 * 条件查询
	 * @throws Exception
	 */
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
			 query.setParameter(1, 14);
			
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
	/**
	 * 分页查询
	 * @throws Exception
	 */
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
			 String hql = "from Computers where cname like ? "//该语句不用写limit,Hibernate自带分页查询
			 		+ "and csize=?";
			 
			 query = session.createQuery(hql);
			 
			 //传参数
			 query.setParameter(0, "%华%");
			 query.setParameter(1, 14);
			 
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
