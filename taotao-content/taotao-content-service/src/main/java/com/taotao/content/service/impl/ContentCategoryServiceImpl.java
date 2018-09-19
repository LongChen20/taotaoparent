package com.taotao.content.service.impl;

import com.taotao.common.EasyUITreeNode;
import com.taotao.common.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.entity.TbContentCategory;
import com.taotao.entity.TbContentCategoryExample;
import com.taotao.mapper.TbContentCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public TaotaoResult saveContentCategory(Long parentid, String name) throws Exception {
        //在映射文件中添加主键返回select LAST_INSERT_ID()
        //填充其他信息。
        TbContentCategory tc = new TbContentCategory();
        tc.setParentId(parentid);
        tc.setCreated(new Date());
        tc.setUpdated(new Date());
        ////状态。可选值:1(正常),2(删除)
        tc.setStatus(1);
        ////排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
        tc.setSortOrder(1);
        tc.setIsParent(false);
        tc.setName(name);
        //执行插入方法
        mapper.insert(tc);
        //更具插入的id查找数据
        TbContentCategory content = mapper.selectByPrimaryKey(parentid);
        //判断是否是父节点。true or false
        if (!content.getIsParent()){
            //更新为是父节点
            content.setIsParent(true);
            mapper.updateByPrimaryKey(content);
        }
        //返回主键
        //调用TaotaoResult中的 ok 方法。其中可返回对象。
        return TaotaoResult.ok(tc);
    }

    @Override
    public TaotaoResult updateNode(Long id, String name){
        //查询要需改的id
        TbContentCategory tc = mapper.selectByPrimaryKey(id);
        //重新复制名字
        tc.setName(name);
        mapper.updateByPrimaryKey(tc);
        return TaotaoResult.ok(tc);
    }
}
