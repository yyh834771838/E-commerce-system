package com.economic.demo.lsy.service;

import com.economic.demo.lsy.mapper.SearchMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

@Resource
private SearchMapper searchMapper;

    public List<Map<String,Object>> findAllLsy(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findAllLsy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByNameUser(Map<String,String> map){
        List<Map<String,Object>> name=null;
        try {
            String content=map.get("name");
            name=searchMapper.findByNameUser(content);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return name;
    }

    public List<Map<String,Object>> findByPrice1(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findByPrice1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByPrice2(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findByPrice2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByPrice3(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findByPrice3();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByPrice4(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findByPrice4();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByIdUser(Map<String,String> map){
        List<Map<String,Object>> list=null;
        try {
            int content= Integer.parseInt(map.get("class2_id"));
            list=searchMapper.findByIdUser(content);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findAllC1(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findAllC1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByIdC2(Map<String,String> map){
        List<Map<String,Object>> list=null;
        try {
            int content= Integer.parseInt(map.get("class1_id"));
            list=searchMapper.findByIdC2(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String,Object> findByIdPro(Map<String,String> map){
        Map<String,Object> list=null;
        try {
            int content= Integer.parseInt(map.get("pro_id"));
            int content2= Integer.parseInt(map.get("user_id"));
            list=searchMapper.findByIdPro(content,content2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String,Object> findByIdProDetail(Map<String,String> map){
        Map<String,Object> list=null;
        try {
            int content= Integer.parseInt(map.get("pro_id"));
            list=searchMapper.findByIdProDetail(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByIdComment(Map<String,String> map){
        List<Map<String,Object>> list=null;
        try {
            int content= Integer.parseInt(map.get("pro_id"));
            list=searchMapper.findByIdComment(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean doUpdate(Map<String,String> map){
        boolean flag=false;
        try {
            int r=searchMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=searchMapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
