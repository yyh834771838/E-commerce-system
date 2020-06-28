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

    @RequestMapping("/all")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=searchService.findAll();
        return list;
    }

    @RequestMapping("/sch")
    public List<Map<String,Object>> findByName(@RequestParam Map<String,String> map){
        List<Map<String,Object>> list=searchService.findByName(map);
        return list;
    }
}
