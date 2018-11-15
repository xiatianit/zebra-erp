package com.zebra.zebraerp.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    
    @RequestMapping("/")
    public Object ok(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "ok");
        map.put("appName", "zebra");
        map.put("riskName", "zebra-name");
        return map;
    }

}
