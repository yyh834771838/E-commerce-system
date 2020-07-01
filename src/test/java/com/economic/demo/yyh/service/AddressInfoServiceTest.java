package com.economic.demo.yyh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddressInfoServiceTest {

    @Resource
    private AddressInfoService addressInfoService;
    @Test
    public void findUserIdByName() {
        Map<String,String> map = new HashMap<>();
        map.put("user_name","lsy");
        System.out.println(addressInfoService.findUserIdByName(map));
    }
}