package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.ProductMapper;
import com.economic.demo.gcf.mapper.SalesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SalesSrevice {

    @Resource

    private SalesMapper salesMapper;
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=salesMapper.save(map);
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
            int id=Integer.parseInt(map.get("sales_id"));
            int r=salesMapper.delete(id);
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
            int r=salesMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public List<Map<String,Object>> findAll(){

        List<Map<String,Object>> list=null;
        try {
            list=salesMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
