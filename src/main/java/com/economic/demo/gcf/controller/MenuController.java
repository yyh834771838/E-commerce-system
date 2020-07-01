package com.economic.demo.gcf.controller;

import com.economic.demo.gcf.service.Class2Service;
import com.economic.demo.gcf.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Resource
    private MenuService menuService;
    @RequestMapping("/menu_findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=menuService.findAll();
        return list;
    }

    @RequestMapping("/menu_findBymenuid")
    public List<Map<String,Object>> findBymenuid(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=menuService.findBymenuid(map);
        return list;
    }
    @RequestMapping("/menu_delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=menuService.doDelete(map);
        if(flag){
            msg="删除成功";
        }

        return msg;

    }

    @RequestMapping("/menu_update")
    public String update(@RequestParam Map<String,String> map){
        String msg="更新失败";
        boolean flag=menuService.doUpdate(map);
        if(flag){
            msg="更新成功";
        }

        return msg;
    }
}
