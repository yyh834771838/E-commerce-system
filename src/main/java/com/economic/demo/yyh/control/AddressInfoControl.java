package com.economic.demo.yyh.control;

import com.economic.demo.yyh.service.AddressInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class AddressInfoControl {
    @Resource
    private AddressInfoService addressInfoService;

    @RequestMapping("/findAllAddress")
    public List<Map<String,Object>> findAll(@RequestParam Map<String,String> map){
        List<Map<String,Object>> info = addressInfoService.findAll(map);
        return info;
    }

    @RequestMapping("/findIdByName")
    public String findUserIdByName(@RequestParam Map<String,String> map){
        String info = addressInfoService.findUserIdByName(map);
        return info;
    }
}
