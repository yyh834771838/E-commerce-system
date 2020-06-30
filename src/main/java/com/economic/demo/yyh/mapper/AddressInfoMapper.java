package com.economic.demo.yyh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
            " where user_id=#{t.user_id}")
    public List<Map<String,Object>> findAll(@Param("t") Map<String,String> map);

    @Select("select user_id from user " +
            " where name=#{t.user_name}")
    public Map<String,Object> findUserIdByName(@Param("t") Map<String,String> map);

}
