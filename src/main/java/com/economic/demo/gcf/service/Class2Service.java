package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.Class2Mapper;
import com.economic.demo.gcf.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Class2Service {

    @Resource

    private Class2Mapper class2Mapper;
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=class2Mapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
            int r=class2Mapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }
    public boolean doUpdate(Map<String,String> map){
        boolean flag=false;
        try {
            int r=class2Mapper.update(map);
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
            list=class2Mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String ,Object>findById(Map<String,String> map){
        Map<String ,Object> tea=null;
        try {
            int id=Integer.parseInt(map.get("id"));
            tea=class2Mapper.findById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }
}
