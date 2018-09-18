package com.taotao.controller;

import com.taotao.common.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author LGCN
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    /**
     * 引入服务
     * 植入service
     */
    @Autowired
    private ContentCategoryService service;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentid) throws Exception {
        //返回json数据
        List<EasyUITreeNode> list = service.listContentCategory(parentid);
        return list;
    }

}
