package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.dao.RoleDao;
import com.web.entity.Role;
import com.web.util.PageUtil;

@Repository
public class RoleDaoImpl extends CommonDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> query(Map<String, Object> params) {
		
		List<Role>  list = new ArrayList<Role>();
		
		try {
			Session session = super.sessionFactory.getCurrentSession();
			
			StringBuffer hql = new StringBuffer("from Role where 1=1 ");
			
			if(params != null){
				for (String key : params.keySet()) {
					if("roleName".equals(key)){
						hql.append(" and roleName  like "+params.get(key));
					}
				}
			}
			
			Query query = session.createQuery(hql.toString());
			
			list = query.list();
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Role> pagingData(PageUtil<Role> paging,
			Map<String, Object> params) {
		
         List<Role>  list = new ArrayList<Role>();
		
		try {
			Session session = super.sessionFactory.getCurrentSession();
			
			StringBuffer hql = new StringBuffer("from Role where 1=1 ");
			
			if(params != null){
				for (String key : params.keySet()) {
					if("roleName".equals(key)){
						hql.append(" and roleName  like "+params.get(key));
					}
				}
			}
			
			Query query = session.createQuery(hql.toString());
			
			query.setFirstResult(paging.getExclude());//设置排除前面多少笔数据
			query.setMaxResults(paging.getPageSize());//设置每页最多显示多少条数据
			
			list = query.list();
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer pagingTotalCount(Map<String, Object> params) {
		
		Integer totalCount = 0;
		
		try {
			Session session = super.sessionFactory.getCurrentSession();
			
			StringBuffer hql = new StringBuffer("select count(*) from Role where 1=1 ");
			
			if(params != null){
				for (String key : params.keySet()) {
					if("roleName".equals(key)){
						hql.append(" and roleName  like "+params.get(key));
					}
				}
			}
			
			Query query = session.createQuery(hql.toString());
			
			totalCount = Integer.parseInt(query.uniqueResult().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

	
}
