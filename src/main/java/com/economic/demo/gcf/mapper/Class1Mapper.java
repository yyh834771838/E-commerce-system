package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Class1Mapper {
    @Select("select * from pro_class1")
    public List<Map<String,Object>> findAll();
    @Insert("insert into pro_class1(name1) " +
            "value(#{class1.name1})")
    public int save(@Param("class1") Map<String, String> map);

    @Update("update pro_class2 "+ "set name1=#{t.name1} where class1_id=#{t.class1_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from pro_class1 where class1_id=#{id}")
    public int delete(int id);
}

