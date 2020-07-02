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
class SettlementControllerTest {

    @Resource
    private MockMvc mockMvc;

//    @Test
//    public void findAdd() throws Exception {
//        MockHttpServletRequestBuilder builder=
//        MockMvcRequestBuilders.get("/add")
//                    .param("name","zyc");
//        //使用mockmvc发送请求，并获取响应
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        //从响应结果中获取其中的内容
//        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
//        System.out.println(str);
//    }

//    @Test
//    public void addMenu() throws Exception {
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.post("/addMenu")
//                        .param("user_id","1")
//                        .param("add_id","1")
//                        .param("time","200")
//                        .param("total","5");
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
//        System.out.println(str);
//    }

//    @Test
//    public void addOrder() throws Exception {
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.post("/addOrder")
//                        .param("name","zyc");
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
//        System.out.println(str);
//    }

//    @Test
//    public void delCart() throws Exception {
//        MockHttpServletRequestBuilder builder=
//                MockMvcRequestBuilders.post("/delCart")
//                        .param("user_id","2");
//        MvcResult rst=mockMvc.perform(builder).andReturn();
//        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
//        System.out.println(str);
//    }

    @Test
    public void totalPrice() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/totalPrice")
                        .param("name","zyc");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }
}