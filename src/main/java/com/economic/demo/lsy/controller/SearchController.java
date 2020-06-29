package com.economic.demo.lsy.controller;

import com.economic.demo.lsy.service.SearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Resource
    private SearchService searchService;

    @RequestMapping("/allLsy")
    public List<Map<String,Object>> findAllLsy(){
        List<Map<String,Object>> list=searchService.findAllLsy();
        return list;
    }

    @RequestMapping("/sch")
    public List<Map<String,Object>> findByNameUser(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=searchService.findByNameUser(map);
        return list;
    }

    @RequestMapping("/src_p1")
    public List<Map<String,Object>> findByPrice1(){
        List<Map<String,Object>> list=searchService.findByPrice1();
        return list;
    }

    @RequestMapping("/src_p2")
    public List<Map<String,Object>> findByPrice2(){
        List<Map<String,Object>> list=searchService.findByPrice2();
        return list;
    }

    @RequestMapping("/src_p3")
    public List<Map<String,Object>> findByPrice3(){
        List<Map<String,Object>> list=searchService.findByPrice3();
        return list;
    }

    @RequestMapping("/src_p4")
    public List<Map<String,Object>> findByPrice4(){
        List<Map<String,Object>> list=searchService.findByPrice4();
        return list;
    }

    @RequestMapping("/pro_id2")
    public List<Map<String,Object>> findByIdUser(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=searchService.findByIdUser(map);
        return list;
    }

    @RequestMapping("/allC1")
    public List<Map<String,Object>> findAllC1(){
        List<Map<String,Object>> list=searchService.findAllC1();
        return list;
    }

    @RequestMapping("/idC2")
    public List<Map<String,Object>> findByIdC2(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=searchService.findByIdC2(map);
        return list;
    }
}
