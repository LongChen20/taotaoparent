package com.taotao.controller;

import com.taotao.common.EasyUIDataGridResult;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LGCN
 */
@Controller
public class ItemController {

    /**
     * 注入Service
     */
   @Autowired
   private ItemService itemService;

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult itemList(Integer page , Integer rows){
        return itemService.findAllTbItem(page,rows);
    }
}
