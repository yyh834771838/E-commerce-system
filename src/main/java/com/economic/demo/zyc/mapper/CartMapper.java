package com.economic.demo.zyc.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {

    @Select("SELECT\n" +
            "a.class2_id,a.photo,a.name,b.id,b.pro_id,b.user_id,b.pro_number,b.pro_price,c.name\n" +
            "FROM product a\n" +
            "INNER JOIN cart b on a.pro_id=b.pro_id\n" +
            "INNER JOIN user c on c.user_id=b.user_id\n" +
            "where c.name=#{name}")
    public List<Map<String,Object>> findAll(String name);

    @Select("select * from cart where user_id=#{n}")
    public Map<String,Object> findByUserid(int id);

    @Insert("insert into cart(pro_id,user_id,pro_number,pro_price)" +
            "value(#{order.pro_id},#{order.user_id},#{order.pro_number},#{order.pro_price})")
    public int save(@Param("order") Map<String,String> map);

    @Update("update cart " +
            " set pro_number=#{order.pro_number}" +
            " where id=#{order.id}")
    public int update(@Param("order") Map<String,String> tea);

    @Delete("delete from cart where id=#{id}")
    public int delete(int id);

    @Update("update cart\n" +
            "set chosen=1\n" +
            "where id=#{id}")
    public int chosen1(int id);

    @Update("update cart\n" +
            "set chosen=0\n" +
            "where id=#{id}")
    public int chosen0(int id);
}
