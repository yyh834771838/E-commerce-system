package com.economic.demo.zyc.zyc.controller;

import com.economic.demo.zyc.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @RequestMapping("/all")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=cartService.findAll();
        return list;
    }

    @RequestMapping("/save")
    public String save(@RequestParam Map<String,String> map){
        String msg="添加失败";
        boolean flag=cartService.doSave(map);
        if(flag){
            msg="添加成功";
        }
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=cartService.doDelete(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    @RequestMapping("/edit")
    public String update(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=cartService.doUpdate(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
}
