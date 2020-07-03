package com.economic.demo.hsf.mapper;

import org.apache.ibatis.annotations.Select;
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
    void getOrderInfo() {
        List<Map<String, Object>> map = customOrderMapper.getOrderInfo("zyc");
        Iterator<Map<String, Object>> iter = map.iterator();
        while (iter.hasNext())
        {
            Map<String, Object> key = iter.next();
            System.out.println("=================================================");
            System.out.println("the name of the product is: " + key.get("name"));
            System.out.println("the price is: " + key.get("pro_price"));
            System.out.println("the number of the product is: " + key.get("pro_number"));
            System.out.println("the status of the product is: " + key.get("status"));
            System.out.println("the time of the order is: " + key.get("time"));
        }
    }

    @Test
    void getCartInfo() {
        List<Map<String,  Object>> map = customOrderMapper.getCartInfo(1);
        Iterator<Map<String, Object>> iter = map.iterator();
        System.out.println(map.get(0).keySet());
        while (iter.hasNext())
        {
            Map<String, Object> key = iter.next();
            System.out.println("=================================================");
            System.out.println("the user_id is: " + key.get("user_id"));
            System.out.println("the username is: " + key.get("uname"));
            System.out.println("the addr_id is: " + key.get("add_id"));
            System.out.println("the menu_id is: " + key.get("menu_id"));
            System.out.println("the time is: " + key.get("time"));
            System.out.println("the total is: " + key.get("total"));
            System.out.println("the status is: " + key.get("status"));
            System.out.println("the price is: " + key.get("pro_price"));
            System.out.println("the number of the product is: " + key.get("pro_number"));
        }
    }

    @Test
    void adminFindDetailByMenuid() {
        List<Map<String,  Object>> map = customOrderMapper.AdminFindDetailByMenuid("1","1","1");
        Iterator<Map<String, Object>> iter = map.iterator();
        System.out.println(map.get(0).keySet());
        while (iter.hasNext())
        {
            Map<String, Object> key = iter.next();
            System.out.println("=================================================");
            System.out.println("the user_id is: " + key.get("user_id"));
            System.out.println("the menu_id is: " + key.get("menu_id"));
            System.out.println("the time is: " + key.get("time"));
            System.out.println("the total is: " + key.get("total"));
            System.out.println("the status is: " + key.get("status"));
            System.out.println("the id of the product is: " + key.get("pro_id"));
            System.out.println("the name of the product is: " + key.get("productname"));
        }
    }

    @Test
    void adminFindDetailByNameOrClass2() {
        List<Map<String,  Object>> map = customOrderMapper.AdminFindDetailByNameOrClass2("1","1");
        Iterator<Map<String, Object>> iter = map.iterator();
        System.out.println(map.get(0).keySet());
        while (iter.hasNext())
        {
            Map<String, Object> key = iter.next();
            System.out.println("=================================================");
            System.out.println("the name of the product is: " + key.get("name"));
            System.out.println("the pro_class2 of the product is: " + key.get("name2"));
            System.out.println("the pro_class1 of the product is: " + key.get("name1"));
            System.out.println("the photo path of the product is: " + key.get("photo"));
        }
    }

    @Test
    void getMemuNum() {
        List<Map<String,  Object>> map = customOrderMapper.getMemuNum();
        System.out.println(map.size());
    }

}