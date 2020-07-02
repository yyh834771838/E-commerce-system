package com.economic.demo.hsf.controller;

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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomOrderControllerTest {

    @Resource
    private MockMvc mockMvc;
    @Test
    void testFindOrder() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/findOrderByUser")
                        .param("user_id","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }


    @Test
    void findProidByMenu() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/findProidByMenu")
                        .param("menu_id","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void getProNameAndPrice() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/getProNameAndPrice")
                        .param("pro","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void getOrderInfo() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/getOrderInfo")
                        .param("username","zyc");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void getCartInfo() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/getCartInfo")
                        .param("menu_id","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void adminFindDetailByMenuid() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/AdminFindDetailByMenuid")
                        .param("menu_id","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void adminFindDetailByNameOrClass2() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/AdminFindDetailByNameOrClass2")
                        .param("name","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void getMemuNum() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/AdminFindDetailByNameOrClass2")
                        .param("name","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }
}