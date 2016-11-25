package com.yao.dao;

import com.yao.model.RolesModel;
import com.yao.model.RolesModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesModelMapper {
    long countByExample(RolesModelExample example);

    int deleteByExample(RolesModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolesModel record);

    int insertSelective(RolesModel record);

    List<RolesModel> selectByExample(RolesModelExample example);

    RolesModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolesModel record, @Param("example") RolesModelExample example);

    int updateByExample(@Param("record") RolesModel record, @Param("example") RolesModelExample example);

    int updateByPrimaryKeySelective(RolesModel record);

    int updateByPrimaryKey(RolesModel record);
}