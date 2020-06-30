package com.economic.demo.gcf.controller;

import com.economic.demo.gcf.service.Class1Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class Class1Controller {


    @Resource
    private Class1Service class1Service;
    @RequestMapping("/class1_findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=class1Service.fingAll();
        return list;
    }
    @RequestMapping("/class1_save")
    public String save(@RequestParam Map<String,String> map){
        String msg="添加失败";
        boolean flag=class1Service.doSave(map);
        if(flag){
            msg="添加成功";
        }
        return msg;
    }
}
