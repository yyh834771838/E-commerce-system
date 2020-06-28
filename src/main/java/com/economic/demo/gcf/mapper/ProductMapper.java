package com.economic.demo.gcf.mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    @Select("select * from product")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param id
     * @return
     */
    @Select("select * from product where pro_id=#{id}")
    public Map<String,Object> findById(int id);

    @Insert("insert into product(class2_id,name,price,hot,details,number,photo) " +
            "value(#{product.class2_id},#{product.name},#{product.price}," +
            "#{product.hot},#{product.details},#{product.number},#{product.photo})")
    public int save(@Param("product") Map<String, String> map);

    @Update("update product "+ "set class2_id=#{t.class2_id},name=#{t.name},price=#{t.price}," +
            "hot=#{t.hot},details=#{t.details},number=#{t.number},photo=#{t.photo}" +"where pro_id=#{t.pro_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from product where pro_id=#{id}")
    public int delete(int id);

}
