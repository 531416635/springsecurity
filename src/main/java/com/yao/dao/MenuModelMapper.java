package com.yao.dao;

import com.yao.model.MenuModel;
import com.yao.model.MenuModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuModelMapper {
    long countByExample(MenuModelExample example);

    int deleteByExample(MenuModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuModel record);

    int insertSelective(MenuModel record);

    List<MenuModel> selectByExample(MenuModelExample example);

    MenuModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuModel record, @Param("example") MenuModelExample example);

    int updateByExample(@Param("record") MenuModel record, @Param("example") MenuModelExample example);

    int updateByPrimaryKeySelective(MenuModel record);

    int updateByPrimaryKey(MenuModel record);
}