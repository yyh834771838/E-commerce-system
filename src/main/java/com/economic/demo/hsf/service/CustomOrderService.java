package com.economic.demo.hsf.service;

import com.economic.demo.hsf.mapper.CustomOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomOrderService {
    @Resource
    private CustomOrderMapper customOrderMapper;

    public boolean findOrder(int userid){
        boolean flag = false;
        try {
            List<Map<String, Object>>  list = new ArrayList<Map<String, Object>>();
            list = customOrderMapper.findOrder(userid);
            if (list != null)
                    flag = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;

    }

}
