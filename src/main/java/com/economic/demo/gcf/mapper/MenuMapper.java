package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    @Select("SELECT " +
            "a.menu_id,b.`name`,a.time,a.total,a.`status` " +
            "FROM menu a " +
            "INNER JOIN `user` b ON a.user_id=b.user_id")
    public List<Map<String,Object>> findAll();

    @Select("SELECT " +
            "b.`name`,a.pro_number,a.pro_price,b.photo " +
            "FROM oderdetails a " +
            "INNER JOIN product b ON a.pro_id=b.pro_id " +
            "WHERE a.menu_id=#{menu_id}")
    public List<Map<String,Object>> findBymenuid(int menu_id);

    @Update("update menu "+ "set user_id=#{t.user_id},add_id=#{t.add_id},time=#{t.time}," +
            "total=#{t.total},status=#{t.status} where menu_id=#{t.menu_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from menu where menu_id=#{id}")
    public int delete(int id);

}
