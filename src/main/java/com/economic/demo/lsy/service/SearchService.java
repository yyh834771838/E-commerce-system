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

    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=null;
        try {
            list=searchMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> findByName(Map<String,String> map){
        List<Map<String,Object>> name=null;
        try {
            String content=map.get("id");
            name=searchMapper.findByName(content);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return name;
    }
}
