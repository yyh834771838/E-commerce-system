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
}