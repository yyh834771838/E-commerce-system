package com.economic.demo.gcf.service;

import com.economic.demo.gcf.mapper.TextMapper;
import com.economic.demo.gcf.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TextService {
    @Resource

    private TextMapper textMapper;

    public List<Map<String,Object>> findByproid(Map<String,String> map){
        List<Map<String,Object>> tea=null;
        try {
            int id=Integer.parseInt(map.get("pro_id"));
            tea=textMapper.findByproid(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }

    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("text_id"));
            int r=textMapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }
}
