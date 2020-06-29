package com.economic.demo.hsf.service;

import com.economic.demo.hsf.mapper.CustomOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class CustomOrderService {
    @Resource
    private CustomOrderMapper customOrderMapper;

    public int[] findOrder(Map<String, String> map){
        boolean flag = false;
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

    public boolean findProductidByMenuid(int menu_id)
    {
        boolean flag = true;
        try {
            int[] list = customOrderMapper.findProductidByMenuid(menu_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

}
