package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TextMapper {

    @Select("SELECT " +
            "a.text_id,a.text_content,b.`name` " +
            "FROM text a " +
            "INNER JOIN `user` b on a.user_id=b.user_id " +
            "WHERE a.pro_id=#{pro_id}")
    public List<Map<String,Object>> findByproid(int pro_id);

    @Delete("delete from text where text_id=#{text_id}")
    public int delete(int text_id);

}
