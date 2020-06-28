package com.economic.demo.yyh.control;

import org.junit.Test;
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
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControlTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void login() {
    }

    @Test
    public void register() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/register")
                        .param("u_name","rrr")
                        .param("u_pwd","122222")
                        .param("u_pwd2","111111")
                        .param("u_tel","15068932191")
                        .param("u_email","834771838@qq.com")
                        .param("u_sex","男");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);

    }
}