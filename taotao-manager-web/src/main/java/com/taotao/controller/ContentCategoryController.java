package com.taotao.controller;

import com.taotao.common.EasyUITreeNode;
import com.taotao.common.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * 后台cms内容管理系统，pojo必须实现  Serializable
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

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentid) throws Exception {
        //返回json数据
        List<EasyUITreeNode> list = service.listContentCategory(parentid);
        return list;
    }

    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult insertNode(Long parentId,String name){
        try {
            return service.saveContentCategory(parentId,name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateNode(Long id,String name){
        try {
            return service.updateNode(id, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
