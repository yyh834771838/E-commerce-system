package com.economic.demo.gcf.controller;


import com.economic.demo.gcf.service.SalesSrevice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class SalesController {
    @Resource
    private SalesSrevice salesSrevice;



    @RequestMapping("/sales_findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=salesSrevice.findAll();
        return list;
    }


    @RequestMapping("/sales_save")
    public String save(@RequestParam Map<String,String> map){
        String msg="添加失败";
        boolean flag=salesSrevice.doSave(map);
        if(flag){
            msg="添加成功";
        }
        return msg;
    }
    @RequestMapping("/sales_delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=salesSrevice.doDelete(map);
        if(flag){
            msg="删除成功";
        }

        return msg;

    }

    @RequestMapping("/sales_update")
    public String update(@RequestParam Map<String,String> map){
        String msg="更新失败";
        boolean flag=salesSrevice.doUpdate(map);
        if(flag){
            msg="更新成功";
        }

        return msg;
    }

}
