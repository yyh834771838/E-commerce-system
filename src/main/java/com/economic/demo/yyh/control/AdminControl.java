package com.economic.demo.yyh.control;



import com.economic.demo.yyh.service.AdminInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class AdminControl {

    @Resource
    private AdminInfoService adminInfoService;

    @RequestMapping("/login")
    public String login(@RequestParam Map<String,String> map){
        String msg="用户名或密码有误!";
        Map<String,Object> info=adminInfoService.checkLogin(map);
        if(info!=null && map.size()>0){
            msg="登录成功";
        }
        return msg;
    }

    @RequestMapping("/adminLogin")
    public int adminLogin(@RequestParam Map<String,String> map){
        int info =adminInfoService.findSystemAdmin(map);
        return info;
    }

    @RequestMapping("/register")
    public String register(@RequestParam Map<String,String> map){
        String info=adminInfoService.checkRegister(map);
        return info;
    }
    @RequestMapping("/findUserDetails")
    public Map<String, Object> findDetailById(@RequestParam Map<String,String> map){
        Map<String, Object> info = adminInfoService.findDetailById(map);
        return info;
    }
    @RequestMapping("/updateUserInfo")
    public String update(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=adminInfoService.updateUserInfo(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
    @RequestMapping("/findUserPassword")
    public String findUserPassword(@RequestParam Map<String,String> map){
        String msg="账号信息有误!请重新填写";
        boolean flag = adminInfoService.findUserPassword(map);
        if(flag){
            msg="密码修改成功";
        }
        return msg;
    }
}
