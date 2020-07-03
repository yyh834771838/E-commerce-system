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

    public List<Map<String, Object>> getOrderInfo(Map<String, String>username){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = username.keySet().iterator();
        if (iter.hasNext()) {
            result =customOrderMapper.getOrderInfo(username.get(iter.next()));
        }
        return result;
    }

    public List<Map<String, Object>> getCartInfo(Map<String, String>menu_id){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = menu_id.keySet().iterator();
        if (iter.hasNext()) {
            result =customOrderMapper.getCartInfo(Integer.valueOf(menu_id.get(iter.next())));
        }
        return result;
    }

    public List<Map<String, Object>> AdminFindDetailByMenuid(Map<String, String>menu_id){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = menu_id.keySet().iterator();
        if (iter.hasNext()) {
            String param = menu_id.get(iter.next());
            result =customOrderMapper.AdminFindDetailByMenuid(param,param,param);
        }
        return result;
    }

    public List<Map<String, Object>> AdminFindDetailByNameOrClass2(Map<String, String>nameorclass2id){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<String> iter = nameorclass2id.keySet().iterator();
        if (iter.hasNext()) {
            String param = nameorclass2id.get(iter.next());
            result =customOrderMapper.AdminFindDetailByNameOrClass2(param,param);
        }
        return result;
    }

    public int getMemuNum(){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        result = customOrderMapper.getMemuNum();
        int length = result.size();
        return length;
    }

    public boolean comment(int pro_id,int user_id,String text_content){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=customOrderMapper.comment(pro_id,user_id,text_content);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }
}
