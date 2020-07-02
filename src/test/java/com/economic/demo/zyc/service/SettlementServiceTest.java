package com.economic.demo.zyc.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SettlementServiceTest {
    @Resource
    private SettlementService settlementService;
//    @Test
//    void findAdd() {
//        List<Map<String,Object>> list=settlementService.findAdd("zyc");
//        System.out.println(list);
//    }
//
//    @Test
//    public void addMenu() {
//        Map<String,String> map=new HashMap<>();
//        map.put("user_id","1");
//        map.put("add_id","1");
//        map.put("time","200");
//        map.put("total","5");
//        boolean flag=settlementService.addMenu(map);
//        assertTrue(flag);
//    }

//    @Test
//    public void addOrder(){
//        boolean flag=settlementService.addOrder("zyc");
//        assertTrue(flag);
//    }
    @Test
    void totalPrice() {
        List<Map<String,Object>> list=settlementService.totalPrice("zyc");
        System.out.println(list);
    }
}