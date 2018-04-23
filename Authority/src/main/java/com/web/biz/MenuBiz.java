package com.web.biz;

import java.util.List;

import com.web.entity.Menu;

public interface MenuBiz {

	  /**
     * 根据父级节点查询菜单数据
     * @param parentId
     * @return
     */
    List<Menu> findByParentId(Integer parentId);
    
    /**
     * 添加
     * @param menu
     * @return
     */
    int insertSelective(Menu menu);
    
    Menu selectByPrimaryKey(Integer menuId);

}
