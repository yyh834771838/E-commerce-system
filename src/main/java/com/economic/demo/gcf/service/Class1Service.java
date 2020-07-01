package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.Class1Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Class1Service {

    @Resource
    private Class1Mapper class1Mapper;
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=class1Mapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public List<Map<String,Object>> fingAll(){

        List<Map<String,Object>> list=null;
        try {
            list=class1Mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
