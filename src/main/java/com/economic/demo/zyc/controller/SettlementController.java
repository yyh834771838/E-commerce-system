package com.economic.demo.zyc.controller;

import com.economic.demo.zyc.service.CartService;
import com.economic.demo.zyc.service.SettlementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class SettlementController {
    @Resource
    private SettlementService settlementService;
    @RequestMapping("/add")
    public List<Map<String,Object>> findAdd(@RequestParam String name){
        List<Map<String,Object>> list=settlementService.findAdd(name);
        return list;
    }

    @RequestMapping("/addMenu")
    public String addMenu(@RequestParam Map<String,String> map){
        String msg="付款失败";
        boolean flag=settlementService.addMenu(map);
        if(flag){
            msg="付款成功";
        }
        return msg;
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam String name){
        String msg="付款失败";
        boolean flag=settlementService.addOrder(name);
        if(flag){
            msg="付款成功";
        }
        return msg;
    }

    @RequestMapping("/delCart")
    public String delCart(@RequestParam int user_id){
        String msg="删除失败";
        boolean flag=settlementService.delCart(user_id);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    @RequestMapping("/totalPrice")
    public List<Map<String,Object>> totalPrice(@RequestParam String name){
        List<Map<String,Object>> list=settlementService.totalPrice(name);
        return list;
    }
}
