package com.economic.demo.hsf.controller;

import com.economic.demo.hsf.service.CustomOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class CustomOrderController {

    @Resource
    private CustomOrderService customOrderService;
    @RequestMapping("/findOrderByUser")
    public int[] findOrder(@RequestParam Map<String, String> map){
        int[] list = customOrderService.findOrder(map);
        return list;
    }

    @RequestMapping("/findProidByMenu")
    public int[] findProidByMenu(@RequestParam Map<String, String> map)
    {
        int[] list = customOrderService.findProductidByMenuid(map);
        return list;
    }

    @RequestMapping("/getProNameAndPrice")
    public Map<String, Object> getProNameAndPrice(@RequestParam Map<String, String>map)
    {
        Map<String, Object> result = customOrderService.getProNameAndPrice(map);
        return result;
    }

    @RequestMapping("/getOrderInfo")
    public List<Map<String, Object>> getOrderInfo(@RequestParam Map<String, String> map)
    {
        List<Map<String, Object>> result = customOrderService.getOrderInfo(map);
        return result;
    }

    @RequestMapping("/getCartInfo")
    public List<Map<String, Object>> getCartInfo(@RequestParam Map<String, String> map)
    {
        List<Map<String, Object>> result = customOrderService.getCartInfo(map);
        return result;
    }

    @RequestMapping("/AdminFindDetailByMenuid")
    public List<Map<String, Object>> AdminFindDetailByMenuid(@RequestParam Map<String, String> map)
    {
        List<Map<String, Object>> result = customOrderService.AdminFindDetailByMenuid(map);
        return result;
    }

    @RequestMapping("/AdminFindDetailByNameOrClass2")
    public List<Map<String, Object>> AdminFindDetailByNameOrClass2(@RequestParam Map<String, String> map)
    {
        List<Map<String, Object>> result = customOrderService.AdminFindDetailByNameOrClass2(map);
        return result;
    }

    @RequestMapping("/getMemuNum")
    public int getMemuNum()
    {
        int length = customOrderService.getMemuNum();
        return length;
    }

    @RequestMapping("/comment")
    public String chosen0(@RequestParam int pro_id,int user_id,String text_content){
        String msg="评论失败";
        boolean flag=customOrderService.comment(pro_id,user_id,text_content);
        if(flag){
            msg="评论成功";
        }
        return msg;
    }
}
