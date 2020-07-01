package com.economic.demo.yyh.service;

import com.economic.demo.yyh.mapper.AddressInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public String addAddress(Map<String,String> map) {
        Map<String,Object> info = addressInfoMapper.findSpecialAddr(map);
        Set<Map.Entry<String,String>> mapSet = map.entrySet();
        for (Map.Entry entry: mapSet) {
            if (entry.getValue().equals(""))
                return "请把信息填写完整！否则快递可能丢失!";
        }
        if (info == null || info.size()==0)
        {
            addressInfoMapper.addAddress(map);
            return "添加成功";
        }
        if (info.get("user_id").toString().equals(map.get("u_id")) && info.get("area_name").toString().equals(map.get("u_area")))
            return "添加失败，改地址已存在";
        addressInfoMapper.addAddress(map);
        return "添加成功";
    }
    public boolean deleteAddress(Map<String,String> map){
        boolean flag=false;
        try {
            int r=addressInfoMapper.deleteAddress(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateAddress(Map<String,String> map){
        boolean flag=false;
        try {
            int r=addressInfoMapper.updateAddress(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
