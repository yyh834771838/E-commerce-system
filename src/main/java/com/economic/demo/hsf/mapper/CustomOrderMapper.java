package com.economic.demo.hsf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomOrderMapper {
    //根据用户id查询对应menu_id
    @Select("select menu_id from menu where user_id = #{userid}")
    public int[] findOrder(int userid);
    //根据menu_id获取menu里的pro_id
    @Select("select pro_id from oderdetails where menu_id = #{menu_id}")
    public int[] findProductidByMenuid(int menu_id);
    //根据pro_id获取商品信息
    @Select("select name, price from product where pro_id = #{pro_id}")
    public Map<String, Object> getProNameAndPrice(int pro_id);

    @Select("SELECT * " +
            "from user a " +
            "INNER JOIN menu b ON b.user_id = a.user_id " +
            "INNER JOIN oderdetails c ON b.menu_id = c.menu_id " +
            "INNER JOIN product d ON c.pro_id = d.pro_id " +

            "WHERE a.name = #{username}")
    public List<Map<String, Object>> getOrderInfo(String username);

    @Select("select *,c.name AS uname, e.name AS pname " +
            "from menu a " +
            "inner join oderdetails b on a.menu_id = b.menu_id " +
            "inner join user c on c.user_id = a.user_id " +
            "inner join address d on d.add_id = a.add_id " +
            "inner join product e on e.pro_id = b.pro_id " +
            "where a.menu_id = #{menu_id}")
    public List<Map<String, Object>> getCartInfo(int menu_id);
    //根据订单号,下单时间,用户名查询详细订单信息
    @Select("select *, d.name as productname from oderdetails a inner join menu b on b.menu_id = a.menu_id inner join user c on c.user_id = b.user_id inner join product d on d.pro_id = a.pro_id where a.menu_id = #{menu_id} or c.name = #{name} or b.time = #{time}")
    public List<Map<String, Object>> AdminFindDetailByMenuid(String menu_id, String name, String time);
    //根据商品名,小类别查询商品信息
    @Select("select * from product a inner join pro_class2 b on b.class2_id = a.class2_id inner join pro_class1 c on c.class1_id = b.class1_id where a.name = #{name} or a.class2_id = #{class2_id}")
    public List<Map<String, Object>> AdminFindDetailByNameOrClass2(String name, String class2_id);

    @Select("select * from menu")
    public List<Map<String, Object>> getMemuNum();

    @Select("SELECT * " +
            "from menu a " +
            "INNER JOIN oderdetails b ON a.menu_id = b.menu_id " +
            "INNER JOIN product c ON c.pro_id = b.pro_id " +
            "WHERE a.name = #{username}")
    public List<Map<String, Object>> getOrderByUserName(String username);
}
