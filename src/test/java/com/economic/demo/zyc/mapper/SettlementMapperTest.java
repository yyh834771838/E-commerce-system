package com.economic.demo.zyc.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SettlementMapperTest {

    @Resource
    private SettlementMapper settlementMapper;

//    @Test
//    void findAdd() {
//        List<Map<String,Object>> list=settlementMapper.findAdd("zyc");
//        System.out.println(list);
//    }
//    @Test
//    void addOrder() {
//        int n=settlementMapper.addOrder("zyc");
//        //junit中的断言，进行提示显示，如果执行的结果跟我们的期望职相同，测试通过
//        assertEquals(2,n);
//    }

//    @Test
//    void addOrder() {
//        Map<String,String> map=new HashMap<>();
//        map.put("user_id","1");
//        map.put("add_id","1");
//        map.put("time","200");
//        map.put("total","5");
//        int n=settlementMapper.addMenu(map);
//        //junit中的断言，进行提示显示，如果执行的结果跟我们的期望职相同，测试通过
//        assertEquals(1,n);
//    }

    @Test
    void totalPrice() {
        List<Map<String,Object>> list=settlementMapper.totalPrice("zyc");
        System.out.println(list);
    }
}