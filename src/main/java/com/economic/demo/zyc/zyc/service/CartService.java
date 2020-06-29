package com.economic.demo.zyc.zyc.service;

import com.economic.demo.zyc.mapper.CartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Resource
    private CartMapper cartMapper;

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=cartMapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
            int r=cartMapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean doUpdate(Map<String,String> map){
        boolean flag=false;
        try {
            int r=cartMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=null;
        try {
            list=cartMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String,Object> findByMenuid(Map<String,String> map){
        Map<String,Object> tea=null;
        try {
            int id=Integer.parseInt(map.get("id"));
            tea=cartMapper.findByMenuid(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }
}
