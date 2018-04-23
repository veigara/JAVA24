package com.web.dao;

import com.web.entity.Role;
import com.web.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 根据角色id查询权限菜单id
     * @param roleId
     * @return
     */
    List<Integer> selectAuthority(Integer roleId);
    
    /**
     * 保存权限
     * @param roleId
     * @param menuId
     * @return
     */
    int insertAuthority(@Param("roleId") Integer roleId,@Param("menuId") Integer menuId);
    
    
    /**
     * 删除权限
     * @param roleId
     * @return
     */
    int deleteAuthority(Integer roleId);
    
}