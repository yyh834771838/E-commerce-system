package com.economic.demo.gcf.controller;


import com.economic.demo.gcf.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * RequestMapping设置该方法的路径
     * @return
     */

    @RequestMapping("/pro_findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=productService.fingAll();
        return list;
    }

    /**
     * RequestParam 通知前端提交的数据要封装成一个map集合
     * 以表单控件的name的值作为map的key
     *
     * @param map
     * @return
     */
    @RequestMapping("/pro_save")
    public String save(@RequestParam Map<String,String> map){
        String msg="添加失败";
        boolean flag=productService.doSave(map);
        if(flag){
            msg="添加成功";
        }
        return msg;
    }
    @RequestMapping("/pro_delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=productService.doDelete(map);
        if(flag){
            msg="删除成功";
        }

        return msg;

    }

    @RequestMapping("/pro_update")
    public String update(@RequestParam Map<String,String> map){
        String msg="更新失败";
        boolean flag=productService.doUpdate(map);
        if(flag){
            msg="更新成功";
        }

        return msg;
    }
    @RequestMapping("/pro_findById")
    public Map<String ,Object> findById(@RequestParam Map<String,String> map){

        Map<String ,Object> list=productService.findById(map);
        return list;

    }
    @RequestMapping("/pro_prodelete")
    public String prodelete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=productService.doprodelete(map);
        if(flag){
            msg="删除成功";
        }

        return msg;
    }

}
