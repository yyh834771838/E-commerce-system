package com.economic.demo.hsf.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CustomOrderServiceTest {
    @Resource CustomOrderService customOrderService;
    @Test
    void findOrder() {
        boolean flag  = false;
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid","1");
        int [] list= customOrderService.findOrder(map);
        if (list!=null)
            flag=true;
        assertTrue(flag);
    }

    @Test
    void findProductidByMenuid() {
        boolean flag  = false;
        Map<String, String> map = new HashMap<String, String>();
        map.put("menu_id","1");
        int[] list = customOrderService.findProductidByMenuid(map);
        if (list != null)
            flag = true;
        assertTrue(flag);
    }

    @Test
    void getProNameAndPrice() {
        boolean flag = false;
        Map<String, String> map = new HashMap<String, String>();
        map.put("pro_id", "1");
        Map<String, Object> result = customOrderService.getProNameAndPrice(map);
        if (result.size()!=0)
        {
            flag = true;
            System.out.println(result.get("name"));
            System.out.println(result.get("price"));
        }
        assertTrue(flag);
    }

    @Test
    void getNamePriceNum() {
        boolean flag = false;
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "1");
        List<Map<String, Object>> result = customOrderService.getOrderInfo(map);
        if (result != null)
            flag = true;
       assertTrue(flag);
    }

    @Test
    void getCartInfo() {
        boolean flag = false;
        Map<String, String> map = new HashMap<>();
        map.put("menu_id", "1");
        List<Map<String, Object>> result = customOrderService.getCartInfo(map);
        if (result != null)
            flag = true;
        assertTrue(flag);
    }
}