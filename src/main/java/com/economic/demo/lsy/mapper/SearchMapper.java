package com.economic.demo.lsy.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    @Select("select * from product")
    public List<Map<String,Object>> findAllLsy();

    @Select("select * from product where name=#{n}")
    public  List<Map<String,Object>> findByNameUser(String name);

    @Select("select * from product where price<=100")
    public  List<Map<String,Object>> findByPrice1();

    @Select("select * from product where price>100 AND price<=500")
    public  List<Map<String,Object>> findByPrice2();

    @Select("select * from product where price>500 AND price<=1000")
    public  List<Map<String,Object>> findByPrice3();

    @Select("select * from product where price>1000")
    public  List<Map<String,Object>> findByPrice4();

    @Select("select * from product where class2_id=#{n}")
    public  List<Map<String,Object>> findByIdUser(int id);

    @Select("select * from pro_class1")
    public List<Map<String,Object>> findAllC1();

    @Select("select * from pro_class2 where class1_id=#{n}")
    public List<Map<String,Object>> findByIdC2(int id);

    @Select("select * from cart where pro_id=#{idp} AND user_id=#{idu}")
    public Map<String,Object> findByIdPro(int idp,int idu);

    @Select("select * from product where pro_id=#{n}")
    public Map<String,Object> findByIdProDetail(int id);

    @Select("select a.text_content,b.name from text a INNER JOIN user b on a.user_id=b.user_id where pro_id=#{n}")
    public List<Map<String,Object>> findByIdComment(int id);

    @Update("update cart " +
            " set pro_number=#{uc.pro_number}" +
            " where pro_id=#{uc.pro_id} AND user_id=#{uc.user_id}")
    public int update(@Param("uc") Map<String,String> map);

    @Insert("insert into cart(user_id,pro_id,pro_number,pro_price,chosen)" +
            "value(#{ac.user_id},#{ac.pro_id},#{ac.pro_number},#{ac.pro_price},#{ac.chosen})")
    public int save(@Param("ac") Map<String,String> map);
}
