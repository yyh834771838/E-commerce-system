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
class CartServiceTest {

    @Resource
    private CartService cartService;
//    @Test
//    public void doSave() {
//        Map<String,String> map=new HashMap<>();
//        map.put("pro_id","1");
//        map.put("user_id","1");
//        map.put("pro_number","200");
//        map.put("pro_price","5");
//        boolean flag=cartService.doSave(map);
//        assertTrue(flag);
//    }

//    @Test
//    public void findAll() {
//        List<Map<String,Object>> list=cartService.findAll("zyc");
//        System.out.println(list);
//    }

//    @Test
//    public void doUpdate() {
//        Map<String,String> map=new HashMap<>();
//        map.put("id","5");
//        map.put("pro_number","777");
//        boolean flag=cartService.doUpdate(map);
//        assertTrue(flag);
//    }
}