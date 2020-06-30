package com.economic.demo.zyc.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {

    @Select("select * from oderdetails")
    public List<Map<String,Object>> findAll();

    @Select("select * from oderdetails where menu_id=#{n}")
    public Map<String,Object> findByMenuid(int id);

    @Insert("insert into oderdetails(pro_id,menu_id,number,price)" +
            "value(#{pro_id},#{menu_id},#{number},#{price})")
    public int save(@Param("order") Map<String, String> map);

    @Update("update oderdetails " +
            " set number=#{num}" +
            " where id=#{id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from oderdetails where id=#{id}")
    public int delete(int id);
}
