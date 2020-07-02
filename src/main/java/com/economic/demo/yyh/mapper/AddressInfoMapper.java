package com.economic.demo.yyh.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddressInfoMapper {
    /**
     * t.name 和t.pwd  其中name和pwd 对应页面表单控件的name属性的值
     * @param map
     * @return
     */
    @Select("select * from address " +
            " where user_id=#{t.user_id} and add_delete=1")
    public List<Map<String,Object>> findAll(@Param("t") Map<String,String> map);

    @Select("select user_id from user " +
            " where name=#{t.user_name}")
    public Map<String,Object> findUserIdByName(@Param("t") Map<String,String> map);

    @Insert("insert into address " +
            " (user_id,receiver_name,number,province,city_name,area_name,add_delete)" +
            " values " +
            " (#{t.u_id},#{t.u_name},#{t.u_tel},#{t.u_prov},#{t.u_city},#{t.u_area},1)")
    public void addAddress(@Param("t") Map<String,String> map);

    @Select("select * from address " +
            " where user_id=#{t.u_id} and area_name=#{t.u_area}")
    public Map<String,Object> findSpecialAddr(@Param("t") Map<String,String> map);

    @Update("update address " +
            " set add_delete=0" +
            " where user_id=#{t.u_id} and receiver_name=#{t.u_name} and area_name=#{t.u_area}")
    public int deleteAddress(@Param("t") Map<String,String> map);

    @Update("update address " +
            " set receiver_name=#{t.u_name}, number=#{t.u_tel}, province=#{t.u_prov}, " +
            "city_name=#{t.u_city},area_name=#{t.u_area}" +
            " where add_id=#{t.add_id}")
    public int updateAddress(@Param("t") Map<String,String> map);
}
