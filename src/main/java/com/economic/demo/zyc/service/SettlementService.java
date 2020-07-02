package com.economic.demo.zyc.service;

import com.economic.demo.zyc.mapper.CartMapper;
import com.economic.demo.zyc.mapper.SettlementMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SettlementService {
    @Resource
    private SettlementMapper settlementMapper;

    public List<Map<String,Object>> findAdd(String name){
        List<Map<String,Object>> list=null;
        try {
            list=settlementMapper.findAdd(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addMenu(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=settlementMapper.addMenu(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean addOrder(String name){
        boolean flag=false;
        try {
            int r=settlementMapper.addOrder(name);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delCart(int user_id){
        boolean flag=false;
        try {
            int r=settlementMapper.delCart(user_id);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
