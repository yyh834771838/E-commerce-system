package com.economic.demo.gcf.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SalesMapper {

    @Select("select * from sales")
    public List<Map<String,Object>> findAll();

    @Delete("delete from sales where sales_id=#{id}")
    public int delete(int id);

    @Insert("insert into sales(cost,sales_total,profit,sales_time) " +
            "value(#{sales.cost},#{sales.sales_total},#{sales.profit}," +
            "#{sales.sales_time})")
    public int save(@Param("sales") Map<String, String> map);

    @Update("update sales "+ "set cost=#{t.cost},sales_total=#{t.sales_total},profit=#{t.profit}," +
            "sales_time=#{t.sales_time}" +"where sales_id=#{t.sales_id}")
    public int update(@Param("t") Map<String, String> tea);

}
