package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LGCN
 */
@Controller
public class ShowIndex {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
