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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressInfoControlTest {

    @Resource
    private MockMvc mockMvc;
    @Test
    public void addAddress() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/addUserAddress")
                        .param("u_id","1")
                        .param("u_name","叶宇航")
                        .param("u_prov","湖北")
                        .param("u_city","武汉")
                        .param("u_tel","15068932191")
                        .param("u_area","关山街道");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }
}