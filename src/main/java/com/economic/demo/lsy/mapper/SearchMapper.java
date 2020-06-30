package com.economic.demo.lsy.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    @Select("select * from product")
    public List<Map<String,Object>> findAllLsy();

    @Select("select * from product where name=#{n}")
    public  List<Map<String,Object>> findByNameUser(String name);

    @Select("select * from product where price<=100")
    public  List<Map<String,Object>> findByPrice1();

    @Select("select * from product where price>100 AND price<=500")
    public  List<Map<String,Object>> findByPrice2();

    @Select("select * from product where price>500 AND price<=1000")
    public  List<Map<String,Object>> findByPrice3();

    @Select("select * from product where price>1000")
    public  List<Map<String,Object>> findByPrice4();

    @Select("select * from product where class2_id=#{n}")
    public  List<Map<String,Object>> findByIdUser(int id);

    @Select("select * from pro_class1")
    public List<Map<String,Object>> findAllC1();

    @Select("select * from pro_class2 where class1_id=#{n}")
    public List<Map<String,Object>> findByIdC2(int id);
}
