package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.Class2Mapper;
import com.economic.demo.gcf.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class MenuService {
    @Resource

    private MenuMapper menuMapper;
    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
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
