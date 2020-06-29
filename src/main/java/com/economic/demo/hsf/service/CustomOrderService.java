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
}
