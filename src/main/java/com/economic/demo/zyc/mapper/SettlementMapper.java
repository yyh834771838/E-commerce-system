package com.economic.demo.zyc.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SettlementMapper {

    @Select("SELECT\n" +
            "a.add_id,a.user_id,a.receiver_name,a.number,a.province,a.city_name,a.area_name,a.first\n" +
            "FROM address a\n" +
            "INNER JOIN user b on a.user_id=b.user_id\n" +
            "WHERE b.name=#{n}")
    public List<Map<String,Object>> findAdd(String name);

    @Insert("insert into menu(user_id,add_id,time,total)" +
            "value(#{order.user_id},#{order.add_id},#{order.time},#{order.total})")
    public int addMenu(@Param("order") Map<String,String> map);

    @Insert("INSERT into oderdetails(pro_id,menu_id,pro_number,pro_price)\n" +
            "SELECT \n" +
            "a.pro_id,(SELECT MAX(menu_id) from menu),a.pro_number,a.pro_price\n" +
            "from cart a\n" +
            "INNER JOIN user b on a.user_id = b.user_id\n" +
            "WHERE b.name=#{name} AND a.chosen=1")
    public int addOrder(String name);

    @Delete("DELETE FROM cart WHERE user_id=#{user_id} AND chosen=1")
    public int delCart(int user_id);

    @Select("SELECT \n" +
            "a.pro_id,(SELECT MAX(menu_id) from menu),a.pro_number,a.pro_price\n" +
            "from cart a\n" +
            "INNER JOIN user b on a.user_id = b.user_id\n" +
            "WHERE b.name=#{name} AND a.chosen=1")
    public List<Map<String,Object>> totalPrice(String name);
}
