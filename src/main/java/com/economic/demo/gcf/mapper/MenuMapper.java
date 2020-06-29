package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface MenuMapper {

    @Update("update menu "+ "set user_id=#{t.user_id},add_id=#{t.add_id},time=#{t.time}," +
            "total=#{t.total},status=#{t.status} where menu_id=#{t.menu_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from menu where menu_id=#{id}")
    public int delete(int id);
}
