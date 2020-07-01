package com.economic.demo.gcf.controller;

import com.economic.demo.gcf.service.TextService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class TextController {
    @Resource
    private TextService textService;
    @RequestMapping("/text_findAll")
    public List<Map<String,Object>> findAll(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=textService.findByproid(map);
        return list;
    }

    @RequestMapping("/text_delete")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=textService.doDelete(map);
        if(flag){
            msg="删除成功";
        }

        return msg;

    }
}
