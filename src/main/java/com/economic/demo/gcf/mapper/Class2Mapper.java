package com.economic.demo.gcf.mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Class2Mapper {

    @Select("SELECT " +
            "b.name1,a.name2,a.class2_id " +
            "FROM pro_class2 a " +
            "INNER JOIN pro_class1 b on a.class1_id=b.class1_id")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param id
     * @return
     */
    @Select("select * from pro_class2 where class2_id=#{id}")
    public Map<String,Object> findById(int id);

    @Select("select class2_id from pro_class2 where name=#{name}")
    public Map<String,Object> findByName(String name);

    @Insert("insert into pro_class2(class1_id,name2) " +
            "value(#{class2.class1_id},#{class2.name2})")
    public int save(@Param("class2") Map<String, String> map);

    @Update("update pro_class2 "+ "set class1_id=#{t.class1_id},name2=#{t.name2} where class2_id=#{t.class2_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from pro_class2 where class2_id=#{id}")
    public int delete(int id);
}
