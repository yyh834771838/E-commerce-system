package com.economic.demo.yyh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface AdminInfoMapper {

    /**
     * t.name 和t.pwd  其中name和pwd 对应页面表单控件的name属性的值
     * @param map
     * @return
     */
    @Select("select * from user " +
            " where name=#{t.u_name}" +
            " and password=#{t.u_pwd}")
    public Map<String,Object> findByNameAndPwd(@Param("t") Map<String,String> map);

    @Select("select * from user " +
            " where name=#{t.u_name}")
    public Map<String,Object> findByName(@Param("t") Map<String,String> map);

    @Select("insert into user " +
            " (name,password,number,email,sex,identity)" +
            " values " +
            " (#{t.u_name},#{t.u_pwd},#{t.u_tel},#{t.u_email},#{t.u_sex},1)")
    public void register(@Param("t") Map<String,String> map);
}