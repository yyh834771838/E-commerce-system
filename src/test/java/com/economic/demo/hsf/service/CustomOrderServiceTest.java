package com.economic.demo.hsf.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CustomOrderServiceTest {
    @Resource CustomOrderService customOrderService;
    @Test
    void findOrder() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        boolean flag = customOrderService.findOrder(2);
        assertTrue(flag);
    }

    @Test
    void findProductidByMenuid() {
        boolean flag = customOrderService.findProductidByMenuid(1);
        assertTrue(flag);
    }
}