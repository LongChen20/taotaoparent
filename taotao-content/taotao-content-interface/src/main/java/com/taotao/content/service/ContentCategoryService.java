package com.taotao.content.service;

import com.taotao.common.EasyUITreeNode;
import com.taotao.common.TaotaoResult;

import java.util.List;

/**
 * 内容分类
 * @author LGCN
 */
public interface ContentCategoryService {

    /**
     * 查询id
     * @param categoryid
     * @return 返回list集合
     * @throws Exception
     */
    List<EasyUITreeNode> listContentCategory(Long categoryid) throws Exception;

    /**
     * 新增节点
     * @param parentid
     * @param name
     * @return
     * @throws Exception
     */
    TaotaoResult saveContentCategory(Long parentid ,String name) throws Exception;

    /**
     * 跟新节点名称
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    TaotaoResult updateNode(Long id,String name) throws Exception;
}
