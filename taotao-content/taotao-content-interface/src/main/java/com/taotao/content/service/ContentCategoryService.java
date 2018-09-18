package com.taotao.content.service;

import com.taotao.common.EasyUITreeNode;

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
}
