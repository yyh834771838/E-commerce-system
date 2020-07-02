package com.economic.demo.gcf.controller;

import com.economic.demo.gcf.service.MenuService;
import com.economic.demo.gcf.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/user_findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=userService.fingAll();
        return list;
    }
    @RequestMapping("/user_findManager")
    public List<Map<String,Object>> findManager(){
        List<Map<String,Object>> list=userService.findManager();
        return list;
    }
    @RequestMapping("/user_save")
    public String save(@RequestParam Map<String,String> map){
        String msg="添加失败";
        boolean flag=userService.doSave(map);
        if(flag){
            msg="添加成功";
        }
        return msg;
    }
    @RequestMapping("/user_delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=userService.doDelete(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    @RequestMapping("/user_update")
    public String update(@RequestParam Map<String,String> map){
        String msg="更新失败";
        boolean flag=userService.doUpdate(map);
        if(flag){
            msg="更新成功";
        }
        return msg;
    }
}
