package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface UserMapper {
    @Update("update user "+ "set name=#{t.name},password=#{t.password},number=#{t.number}," +
            "email=#{t.email},sex=#{t.sex},identity=#{t.identity} where user_id=#{t.user_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from user where user_id=#{id}")
    public int delete(int id);
}
