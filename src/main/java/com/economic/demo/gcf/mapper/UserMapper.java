package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * from `user` a WHERE a.identity=\"1\"")
    public List<Map<String,Object>> findAll();

    @Select("SELECT * from `user` a WHERE a.identity=\"2\"")
    public List<Map<String,Object>> findManager();

    @Insert("insert into user(name,password,number,email,sex,identity) " +
            "value(#{user.name},#{user.password},#{user.number}," +
            "#{user.email},#{user.sex},#{user.identity})")
    public int save(@Param("user") Map<String, String> map);

    @Update("update user "+ "set name=#{t.name},password=#{t.password},number=#{t.number}," +
            "email=#{t.email},sex=#{t.sex},identity=#{t.identity} where user_id=#{t.user_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from user where user_id=#{id}")
    public int delete(int id);
}
