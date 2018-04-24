package com.web.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.web.entity.Bread;
import com.web.entity.Car;
import com.web.entity.Category;
import com.web.entity.Classes;
import com.web.entity.Menu;
import com.web.entity.Passenger;
import com.web.entity.Role;
import com.web.entity.Teacher;
import com.web.util.HibernateUtil;

public class TestAccotion {

	@Test
	public void testOneToMany() throws Exception {
		//1.获取session对象
		Session session  = null;
		
		//2.开启事务
		Transaction trans  = null;
		
		try {
			//1.获取session对象
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//持久化操作
			Classes c1 = new Classes();
			c1.setCname("java22");
			session.save(c1);
			
			Classes c2 = new Classes();
			c2.setCname("java23");
			session.save(c2);
			
			Set<Classes> clist = new HashSet();
			clist.add(c1);
			clist.add(c2);
			
			Teacher t = new Teacher();
			t.setTname("张三");
			t.setClist(clist);
			session.save(t);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	
	@Test
	public void testManyToOne() throws Exception {
		//1.获取session对象
		Session session  = null;
		
		//2.开启事务
		Transaction trans  = null;
		
		try {
			//1.获取session对象
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//持久化操作
			 Bread b = new Bread();
			 b.setBname("面包");
			 session.save(b);
			 
			 Category c1 = new Category();
			 c1.setCname("奶油");
			 c1.setBread(b);
			 session.save(c1);
			 
			 Category c2 = new Category();
			 c2.setCname("巧克力");
			 c2.setBread(b);
			 session.save(c2);
			 
			 Category c3 = new Category();
			 c3.setCname("黄油");
			 c3.setBread(b);
			 session.save(c3);
			
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	@Test
	public void testManyToMany() throws Exception {
		//1.获取session对象
		Session session  = null;
		
		//2.开启事务
		Transaction trans  = null;
		
		try {
			//1.获取session对象
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//持久化操作
			 Menu m1 = new Menu();
			 m1.setmName("菜单管理");
			 session.save(m1);
			 
			 Menu m2 = new Menu();
			 m2.setmName("角色管理");
			 session.save(m2);
			 
			 Menu m3 = new Menu();
			 m3.setmName("用户管理");
			 session.save(m3);
			 
			 Menu m4 = new Menu();
			 m4.setmName("订单管理");
			 session.save(m4);
			 
			 Set<Menu> menuSet1 = new  HashSet<>();
			 menuSet1.add(m1);
			 menuSet1.add(m2);
			 menuSet1.add(m3);
			 menuSet1.add(m4);
			 
			 Role r1 = new Role();
			 r1.setRname("管理员");
			 r1.setMenuSet(menuSet1);
			 session.save(r1);
			 
			 Set<Menu> menuSet2 = new  HashSet<>();
			 menuSet2.add(m1);
			 menuSet2.add(m2);
			 
			 Role r2 = new Role();
			 r2.setRname("普通用户");
			 r2.setMenuSet(menuSet2);
			 session.save(r2);
			
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}		
	}
	
	@Test
	public void testManyToManyTwo() throws Exception {
		//1.获取session对象
		Session session  = null;
		
		//2.开启事务
		Transaction trans  = null;
		
		try {
			//1.获取session对象
			 session = HibernateUtil.getSession();
			
			//2.开启事务
			 trans = session.beginTransaction();
			
			//持久化操作
			 Car c1 = new Car();
			 c1.setCname("879");
			 session.save(c1);
			 
			 Car c2 = new Car();
			 c2.setCname("889");
			 session.save(c2);
			 
			 Car c3 = new Car();
			 c3.setCname("869");
			 session.save(c3);
			 
			 Set<Car> carSet1 = new HashSet<>();
			 carSet1.add(c1);
			 carSet1.add(c2);
			 
			 Passenger p1 = new Passenger();
			 p1.setpName("张三");
			 p1.setCarSet(carSet1);
			 session.save(p1);
			 
			 
			 Set<Car> carSet2 = new HashSet<>();
			 carSet2.add(c1);
			 carSet2.add(c2);
			 carSet2.add(c3);
			 
			 Passenger p2 = new Passenger();
			 p2.setpName("李四");
			 p2.setCarSet(carSet2);
			 session.save(p2);
			
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}	
	}
	
	
	
	
	
}
