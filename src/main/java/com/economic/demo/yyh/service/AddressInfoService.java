package com.economic.demo.yyh.service;

import com.economic.demo.yyh.mapper.AddressInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AddressInfoService {

    @Resource
    private AddressInfoMapper addressInfoMapper;

    public List<Map<String,Object>> findAll(Map<String,String> map){
        List<Map<String,Object>> info=null;
        try{
            info=addressInfoMapper.findAll(map);
        }catch (Exception ex){
        }

        return info;
    }

    public String findUserIdByName(Map<String,String> map) {
        Map<String,Object> info = addressInfoMapper.findUserIdByName(map);
        return info.get("user_id").toString();
    }

}
