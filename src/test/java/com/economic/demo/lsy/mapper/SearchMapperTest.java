package com.economic.demo.lsy.mapper;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchMapperTest {

    @Resource
    private SearchMapper searchMapper;

    @Test
    public void findAll() {
        List<Map<String, Object>> list = searchMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void findByName() {
        List<Map<String, Object>> map = searchMapper.findByName("ipad");
        System.out.println(map);
    }
}