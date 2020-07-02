package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.MenuMapper;
import com.economic.demo.gcf.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource

    private UserMapper userMapper;
    public List<Map<String,Object>> fingAll(){

        List<Map<String,Object>> list=null;
        try {
            list=userMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Map<String,Object>> findManager(){

        List<Map<String,Object>> list=null;
        try {
            list=userMapper.findManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        try {
            int r=userMapper.save(map);
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
            int id=Integer.parseInt(map.get("user_id"));
            int r=userMapper.delete(id);
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
            int r=userMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
