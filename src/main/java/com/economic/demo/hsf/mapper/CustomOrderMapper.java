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
    //根据menu_id获取menu里的pro_id
    @Select("select pro_id from oderdetails where menu_id = #{menu_id}")
    public int[] findProductidByMenuid(int menu_id);
    //根据pro_id获取商品信息
    @Select("select name, price from product where pro_id = #{pro_id}")
    public Map<String, Object> getProNameAndPrice(int pro_id);
}
