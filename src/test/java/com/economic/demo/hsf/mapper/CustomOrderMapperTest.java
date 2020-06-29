package com.economic.demo.hsf.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
        List<Map<String, Object>> list = customOrderMapper.findOrder(1);
        System.out.println(list);
    }
}