package com.economic.demo.hsf.service;

import com.economic.demo.hsf.mapper.CustomOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CustomOrderService {
    @Resource
    private CustomOrderMapper customOrderMapper;

//    public ArrayList<Integer> findOrder(int userid){
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list = customOrderMapper.findOrder(userid);
//
//    }

}
