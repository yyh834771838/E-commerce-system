package com.economic.demo.hsf.service;

import com.economic.demo.hsf.mapper.CustomOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CustomOrderService {
    @Resource
    private CustomOrderMapper customOrderMapper;

    public int[] findOrder(Map<String, String> map){
        int[] list = null;
        try {
            Iterator<String> iter = map.keySet().iterator();
            if (iter.hasNext()) {
                list = customOrderMapper.findOrder(Integer.valueOf(map.get(iter.next())));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int[] findProductidByMenuid(Map<String, String> map)
    {
        int[] list = null;
        try {
            Iterator<String> iter = map.keySet().iterator();
            if(iter.hasNext())
            {
                list = customOrderMapper.findProductidByMenuid(Integer.valueOf(map.get(iter.next())));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> getProNameAndPrice(Map<String, String>pro_id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
            Iterator<String> iter = pro_id.keySet().iterator();
            if (iter.hasNext()) {
                map = customOrderMapper.getProNameAndPrice(Integer.valueOf(pro_id.get(iter.next())));
            }
            return map;
    }

    public List<Map<String, Object>> getOrderInfo(Map<String, String>user_id){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = user_id.keySet().iterator();
        if (iter.hasNext()) {
            result =customOrderMapper.getOrderInfo(Integer.valueOf(user_id.get(iter.next())));
        }
        return result;
    }

    public List<Map<String, Object>> getCartInfo(Map<String, String>menu_id){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = menu_id.keySet().iterator();
        if (iter.hasNext()) {
            result =customOrderMapper.getOrderInfo(Integer.valueOf(menu_id.get(iter.next())));
        }
        return result;
    }


}
