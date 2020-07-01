package com.economic.demo.zyc.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CartControllerTest {

    @Resource
    private MockMvc mockMvc;
//    @Test
//    public void findAll() throws Exception {
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.get("/all")
//                        .param("name","zyc");
//        //使用mockmvc发送请求，并获取响应
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        //从响应结果中获取其中的内容
//        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
//        System.out.println(str);
//    }
//    @Test
//    public void save() throws Exception {
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.post("/save")
//                        .param("pro_id","1")
//                        .param("user_id","1")
//                        .param("pro_number","200")
//                        .param("pro_price","5");
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
//        System.out.println(str);
//    }

    @Test
    public void delete() throws Exception {
        //构建一个请求对象，get请求
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.get("/delete")
                        .param("id","5");
        //使用mockmvc发送请求，并获取响应
        MvcResult rst=mockMvc.perform(builder).andReturn();
        //从响应结果中获取其中的内容
        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(str);
    }

//    @Test
//    public void update() throws Exception {
//        //构建一个请求对象，get请求
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.get("/update")
//                        .param("pro_number","150")
//                        .param("id","5");
//        //使用mockmvc发送请求，并获取响应
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        //从响应结果中获取其中的内容
//        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
//        System.out.println(str);
//    }
}