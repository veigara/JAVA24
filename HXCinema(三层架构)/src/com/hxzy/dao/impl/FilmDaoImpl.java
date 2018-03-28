package com.hxzy.dao.impl;

import java.util.List;
import java.util.Map;

import com.hxzy.dao.FilmDao;
import com.hxzy.entity.Film;
import com.hxzy.util.BaseDao;

public class FilmDaoImpl  extends BaseDao  implements FilmDao {

	@Override
	public int insert(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Film t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Film findById(Film t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	
	/**
	 * 分页,根据条件查询电影信息
	 */
	public List<Film> query(int page, int pageSize, Map<String, Object> map) {
		String sql="select fno, name,type,location,time,date,info from film where 1=1 ";
		StringBuffer st = new StringBuffer();
		st.append(sql);
		Object [] parms=null;
		if(map.size()>0) {
			parms=new Object [map.size()];
		
		//"and type = ?"
		int i=0;
		for (String key :map.keySet()) {
			st.append(" and"+ key +"=?");
			parms[i++]=map.get(key);
		}
		}
		String limit="limit "+(page-1)*pageSize+","+pageSize;
		st.append(limit);
		
		return this.query(Film.class, st.toString(), parms);
	}
	
	@Override
	/**
	 * 分页,根据条件查询电影信息,显示总的电影条数
	 */
	public int total(Map<String, Object> map) {
		String sql="select fno, name,type,location,time,date,info from film where 1=1 ";
		StringBuffer st = new StringBuffer();
		st.append(sql);
		Object [] parms=null;
		try {
		if(map.size()>0) {
			parms=new Object [map.size()];
		
		//"and type = ?"
		int i=0;
		for (String key :map.keySet()) {
			st.append(" and"+ key +"=?");
			parms[i++]=map.get(key);
		}
		
		}
		}catch(Exception e) {
			
		}
		return this.query(Film.class, st.toString(), parms).size();
	}

	@Override
	public Film queryByName(String name) {
		String sql="select f.fno fNo,f.name name,f.type type,f.location location,f.time time,f.date date,f.info info from film f where f.name=?";
		List<Film> query = this.query(Film.class, sql,name);
		for (Film film : query) {
			return film;
		}
		return null;
		
	}

	@Override
	
	public List<Film> query(int page, int pageSize) {
		String sql="select  name from film limit "+(page-1)*pageSize +","+pageSize;
		return this.query(Film.class, sql);
		
		
		
	}

	@Override
	public int total() {
		String sql="select  name from film  ";
		return this.query(Film.class, sql).size();
	}

	

}
