package com.economic.demo.hsf.controller;

import com.economic.demo.hsf.service.CustomOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@RestController
public class CustomOrderController {

    @Resource
    private CustomOrderService customOrderService;
    @RequestMapping("/findOrderByUser")
    public int[] findOrder(@RequestParam Map<String, String> map){
        int[] list = customOrderService.findOrder(map);
        System.out.println(Arrays.toString(list));
        return list;
    }
}
