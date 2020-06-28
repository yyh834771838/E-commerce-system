package com.economic.demo.gcf.service;


import com.economic.demo.gcf.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    @Resource

    private ProductMapper productMapper;
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=productMapper.save(map);
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
            int r=productMapper.delete(id);
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
            int r=productMapper.update(map);
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
            list=productMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String ,Object>findById(Map<String,String> map){
        Map<String ,Object> tea=null;
        try {
            int id=Integer.parseInt(map.get("id"));
            tea=productMapper.findById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }
}
