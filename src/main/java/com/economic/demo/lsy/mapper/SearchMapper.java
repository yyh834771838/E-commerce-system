package com.economic.demo.lsy.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    @Select("select * from product")
    public List<Map<String,Object>> findAll();

    @Select("select * from product where name=#{n}")
    public  List<Map<String,Object>> findByName(String name);
}
