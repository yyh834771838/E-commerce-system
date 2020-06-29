package com.economic.demo.hsf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface CustomOrderMapper {
    //根据用户id查询对应menu_id
    @Select("select menu_id from menu where user_id = #{userid}")
    public int[] findOrder(int userid);

    @Select("select pro_id from oderdetails where menu_id = #{menu_id}")
    public int[] findProductidByMenuid(int menu_id);
    //
}
