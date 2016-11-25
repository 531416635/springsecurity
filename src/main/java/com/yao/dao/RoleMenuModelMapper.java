package com.yao.dao;

import com.yao.model.RoleMenuModel;
import com.yao.model.RoleMenuModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuModelMapper {
    long countByExample(RoleMenuModelExample example);

    int deleteByExample(RoleMenuModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuModel record);

    int insertSelective(RoleMenuModel record);

    List<RoleMenuModel> selectByExample(RoleMenuModelExample example);

    RoleMenuModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenuModel record, @Param("example") RoleMenuModelExample example);

    int updateByExample(@Param("record") RoleMenuModel record, @Param("example") RoleMenuModelExample example);

    int updateByPrimaryKeySelective(RoleMenuModel record);

    int updateByPrimaryKey(RoleMenuModel record);
}