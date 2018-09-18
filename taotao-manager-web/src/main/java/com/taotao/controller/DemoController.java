package com.taotao.controller;

import com.taotao.service.DemoDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LGCN
 */
@Controller
public class DemoController {

    @Autowired
   private DemoDateService dateService;

    @RequestMapping("/demo/date")
    @ResponseBody
    public String demo(){
        System.out.println("测试方法。。。。");
        return dateService.demodate();
    }

//    @RequestMapping("/demo/date")
//    public void date(){
//        System.out.println(dateService.demodate());
//    }

}
