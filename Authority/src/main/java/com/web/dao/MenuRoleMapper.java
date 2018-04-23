package com.web.dao;

import com.web.entity.MenuRoleExample;
import com.web.entity.MenuRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper {
    long countByExample(MenuRoleExample example);

    int deleteByExample(MenuRoleExample example);

    int deleteByPrimaryKey(MenuRoleKey key);

    int insert(MenuRoleKey record);

    int insertSelective(MenuRoleKey record);

    List<MenuRoleKey> selectByExample(MenuRoleExample example);

    int updateByExampleSelective(@Param("record") MenuRoleKey record, @Param("example") MenuRoleExample example);

    int updateByExample(@Param("record") MenuRoleKey record, @Param("example") MenuRoleExample example);
}