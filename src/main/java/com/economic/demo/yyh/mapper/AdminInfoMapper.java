package com.economic.demo.yyh.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
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

    @Insert("insert into user " +
            " (name,password,number,email,sex,identity)" +
            " values " +
            " (#{t.u_name},#{t.u_pwd},#{t.u_tel},#{t.u_email},#{t.u_sex},1)")
    public void register(@Param("t") Map<String,String> map);

    @Select("select * from user " +
            " where user_id=#{t.user_id}")
    public Map<String,Object> findDetailById(@Param("t") Map<String,String> map);

    @Update("update user " +
            " set name=#{t.u_name}, password=#{t.u_pwd},number=#{t.u_tel}, email=#{t.u_email}, sex=#{t.u_sex}" +
            " where user_id=#{t.u_id}")
    public int updateUserInfo(@Param("t") Map<String,String> map);

    @Select("select * from user " +
            " where name=#{t.u_name} and number=#{t.u_tel} and email=#{t.u_email}")
    public Map<String,Object> findPassword(@Param("t") Map<String,String> map);

    @Update("update user " +
            " set  password=#{t.u_pwd}" +
            " where name=#{t.u_name}")
    public int updateUserPassword(@Param("t") Map<String,String> map);
}