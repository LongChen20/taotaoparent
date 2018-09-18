package com.taotao.content.service.impl;

import com.taotao.common.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.entity.TbContentCategory;
import com.taotao.entity.TbContentCategoryExample;
import com.taotao.mapper.TbContentCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类
 * @author LGCN
 */

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    /**
     * 注入mapper
     */
    @Autowired
    private TbContentCategoryMapper mapper;

    @Override
    public List<EasyUITreeNode> listContentCategory(Long categoryid) throws Exception {
        //创建Example件对象。
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(categoryid);
        //调用查询方法。
        List<TbContentCategory> list= mapper.selectByExample(example);
        //返回的list集合
        List<EasyUITreeNode> result = new ArrayList<>();
        for (TbContentCategory category : list) {
            //需要转换的对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(category.getId());
            node.setState(category.getIsParent()?"closed":"open");
            node.setText(category.getName());
            //对象添加到list集合。
            result.add(node);
        }
        //返回list
        //暴露服务
        return result;
    }
}
