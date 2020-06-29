package com.economic.demo.gcf.mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Class2Mapper {

    @Select("select * from pro_class2")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param id
     * @return
     */
    @Select("select * from pro_class2 where class2_id=#{id}")
    public Map<String,Object> findById(int id);

    @Insert("insert into pro_class2(class1_id,name) " +
            "value(#{class2.class1_id},#{class2.name})")
    public int save(@Param("class2") Map<String, String> map);

    @Update("update pro_class2 "+ "set class1_id=#{t.class1_id},name=#{t.name} where class2_id=#{t.class2_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from pro_class2 where class2_id=#{id}")
    public int delete(int id);
}
