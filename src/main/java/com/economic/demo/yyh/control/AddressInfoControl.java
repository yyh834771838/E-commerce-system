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

    @RequestMapping("/addUserAddress")
    public String addAddress(@RequestParam Map<String,String> map) {
        String  rst = addressInfoService.addAddress(map);
        return rst;
    }
    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=addressInfoService.deleteAddress(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }
    @RequestMapping("/updateAddress")
    public String updateAddress(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=addressInfoService.updateAddress(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
}
