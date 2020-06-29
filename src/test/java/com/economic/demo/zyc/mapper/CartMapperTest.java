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
class CartMapperTest {

    @Resource
    private CartMapper cartMapper;
//    @Test
//    public void findAll() {
//        List<Map<String,Object>> list=cartMapper.findAll();
//        System.out.println(list);
//    }

//    @Test
//    public void delete() {
//        int n=cartMapper.delete(5);
//        assertEquals(1,n);
//    }

//    @Test
//    public void save() {
//        Map<String,String> map=new HashMap<>();
//        map.put("pro_id","1");
//        map.put("menu_id","1");
//        map.put("number","200");
//        map.put("price","5");
//        int n=cartMapper.save(map);
//        //junit中的断言，进行提示显示，如果执行的结果跟我们的期望职相同，测试通过
//        assertEquals(1,n);
//    }

    @Test
    public void update() {
        Map<String,String> tea=new HashMap<>();
        tea.put("number","123");
        tea.put("id","5");
        int n=cartMapper.update(tea);
        assertEquals(1,n);
    }

}