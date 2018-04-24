package com.web.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.web.entity.Menu;
import com.web.util.HibernateUtil;

public class TestQuery {

	@Test
	public void testSqlQuery() throws Exception {
		
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			
			String sql = "select * from t_menu";
			
			SQLQuery query = session.createSQLQuery(sql);
				
			List<Object[]> list = query.list();
			
		    for (Object[] obj : list) {
		    	System.out.println("菜单名称:"+obj[1]);
			}
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用占位符传参数    分顺序
	 * @throws Exception
	 */
	@Test
	public void testQueryByCondition1() throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			
//			String sql = "select * from t_menu where mName like '%菜单%'";
			String hql = "from Menu where mName like ?";
			
            Query query =  session.createQuery(hql);
            query.setParameter(0, "%菜单%");
				
			List<Menu> list = query.list();
			
		   for (Menu menu : list) {
			   System.out.println("菜单名称:"+menu.getmName());
		  }
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用别名传参数  不分顺序
	 * @throws Exception
	 */
	@Test
	public void testQueryByCondition2() throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			
//			String sql = "select * from t_menu where mName like '%菜单%'";
			String hql = "from Menu where mName like :menuName";
			
            Query query =  session.createQuery(hql);
            query.setParameter("menuName", "%菜单%");
				
			List<Menu> list = query.list();
			
		   for (Menu menu : list) {
			   System.out.println("菜单名称:"+menu.getmName());
		  }
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCount() throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			 //select count(*) from t_menu
			String hql = "select count(*) from Menu";

			Query query = session.createQuery(hql);
			
			int counts = Integer.parseInt(query.uniqueResult().toString());
			
			System.out.println("总条数为："+counts);
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testColumn() throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			 //select mName from t_menu
			String hql = "select mId,mName from Menu";
			
			Query query = session.createQuery(hql);
			
			List<Object[]> list = query.list();
			
//			for (String s : list) {
//				System.out.println(s);
//			}
			
			for (Object[] obj : list) {
				System.out.println(obj[1]);
			}
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCriteria() throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction trans = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Menu.class);
			
			List<Menu> list = criteria.add(Restrictions.like("mName", "%菜单%"))
					.add(Restrictions.eq("mId", 1)).list();
			
			for (Menu menu : list) {
				System.out.println("菜单名称："+menu.getmName());
			}
			
				
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
