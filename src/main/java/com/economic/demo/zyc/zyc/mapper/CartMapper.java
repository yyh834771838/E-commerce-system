package com.economic.demo.zyc.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {

    @Select("SELECT \n" +
            "a.class2_id,a.photo,a.name,b.id,b.pro_id,b.menu_id,b.number,b.price \n" +
            "FROM product a \n" +
            "INNER JOIN oderdetails b on a.pro_id=b.pro_id")
    public List<Map<String,Object>> findAll();

    @Select("select * from oderdetails where menu_id=#{n}")
    public Map<String,Object> findByMenuid(int id);

    @Insert("insert into oderdetails(pro_id,menu_id,number,price)" +
            "value(#{order.pro_id},#{order.menu_id},#{order.number},#{order.price})")
    public int save(@Param("order") Map<String,String> map);

    @Update("update oderdetails " +
            " set number=#{order.number}" +
            " where id=#{order.id}")
    public int update(@Param("order") Map<String,String> tea);

    @Delete("delete from oderdetails where id=#{id}")
    public int delete(int id);
}
