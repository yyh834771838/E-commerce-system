package com.economic.demo.hsf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface CustomOrderMapper {
    @Select("select menu_id, user_id from menu where user_id = #{userid}")
    public List<Map<String,Object>> findOrder(int userid);
}
