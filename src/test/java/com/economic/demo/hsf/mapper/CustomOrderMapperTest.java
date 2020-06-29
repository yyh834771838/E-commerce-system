package com.economic.demo.hsf.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CustomOrderMapperTest {
    @Resource
    private CustomOrderMapper customOrderMapper;
    @Test
    void findOrder() {
        int[] list = customOrderMapper.findOrder(1);
        System.out.println(Arrays.toString(list));
    }


    @Test
    void findProductidByMenuid() {
        int[] list = customOrderMapper.findProductidByMenuid(1);
        for(int i = 0 ; i< list.length;i++)
        {
            System.out.print("pro_id: ");
            System.out.println(list[i]);
        }
    }

    @Test
    void getProNameAndPrice() {
        Map<String, Object> map = customOrderMapper.getProNameAndPrice(1);
        Iterator<String> iter = map.keySet().iterator();
        if (iter.hasNext()){
            String key = iter.next();
            System.out.println("the price of the product is " + map.get("price"));
            System.out.println("the name of the product is " + map.get("name"));
        }
    }

    @Test
    void getNameAndPrice() {
        List<Map<String, Object>> map = customOrderMapper.getNameAndPrice(1);
        Iterator<Map<String, Object>> iter = map.iterator();
        while (iter.hasNext())
        {
            Map<String, Object> key = iter.next();
            System.out.println("the name of the product is: " + key.get("name"));
            System.out.println("the price is: " + key.get("pro_price"));
        }
    }
}