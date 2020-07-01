package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.Class2Mapper;
import com.economic.demo.gcf.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {
    @Resource

    private MenuMapper menuMapper;
    public List<Map<String,Object>> findAll(){

        List<Map<String,Object>> list=null;
        try {
            list=menuMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Map<String,Object>> findBymenuid(Map<String,String> map){
        List<Map<String,Object>> tea=null;
        try {
            int id=Integer.parseInt(map.get("menu_id"));
            tea=menuMapper.findBymenuid(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }
    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("menu_id"));
            int r=menuMapper.delete(id);
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
            int r=menuMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
