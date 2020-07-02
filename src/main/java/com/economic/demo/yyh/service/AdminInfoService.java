package com.economic.demo.yyh.service;

import com.economic.demo.yyh.mapper.AdminInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    public Map<String,Object> checkLogin(Map<String,String> map){
        Map<String,Object> info=null;
        try{
            info=adminInfoMapper.findByNameAndPwd(map);
        }catch (Exception ex){

        }

        return info;
    }

    public String checkRegister(Map<String,String> map){
        Map<String,Object> info=null;
        try{
            info=adminInfoMapper.findByName(map);
        }catch (Exception ex){

        }
        if (map == null || map.size() == 0 || map.get("u_name").equals("") || map.get("u_pwd").equals(""))
            return "请先填写信息";
        if (info != null && info.size() != 0)
            return "账号已存在";
        if (!map.get("u_pwd").equals(map.get("u_pwd2")))
            return "两次密码不一致";
        adminInfoMapper.register(map);
        return "注册成功";
    }

    public Map<String,Object> findDetailById(Map<String,String> map) {
        Map<String,Object> info = adminInfoMapper.findDetailById(map);
        return info;
    }

    public boolean updateUserInfo(Map<String,String> map){
        boolean flag=false;
        try {
            int r=adminInfoMapper.updateUserInfo(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean findUserPassword(Map<String,String> map) {
        boolean flag = false;
        Map<String,Object> tmp = adminInfoMapper.findPassword(map);
        if (tmp!=null && tmp.size()>0)
        {
            int len = adminInfoMapper.updateUserPassword(map);
            if (len > 0)
                return true;
        }
        return false;
    }
}
