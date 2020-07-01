package com.economic.demo.gcf.mapper;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.javassist.runtime.Inner;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    @Select("select " +
            "a.pro_id,a.name,b.name2,a.price,a.hot,a.details,a.number,a.photo "+
            "from product a " +
            "INNER JOIN pro_class2 b on a.class2_id=b.class2_id "+
            "where a.pro_delete=\"1\"")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param id
     * @return
     */
    @Select("select * from product where pro_id=#{id}")
    public Map<String,Object> findById(int id);

    @Insert("insert into product(class2_id,name,price,hot,details,number,photo,pro_delete) " +
            "value(#{product.class2_id},#{product.name},#{product.price}," +
            "#{product.hot},#{product.details},#{product.number},#{product.photo},#{product.pro_delete})")
    public int save(@Param("product") Map<String, String> map);

    @Update("update product "+ "set class2_id=#{t.class2_id},name=#{t.name},price=#{t.price}," +
            "hot=#{t.hot},details=#{t.details},number=#{t.number},photo=#{t.photo},pro_delete=#{t.pro_delete}" +"where pro_id=#{t.pro_id}")
    public int update(@Param("t") Map<String, String> tea);

    @Delete("delete from product where pro_id=#{id}")
    public int delete(int id);

    @Update("update product"+" set pro_delete=\"0\""+"where pro_id=#{t.pro_id}")
    public int prodelete(@Param("t") Map<String, String> tea);
}
