package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIDataGridResult;
import com.taotao.entity.TbItem;
import com.taotao.entity.TbItemExample;
import com.taotao.mapper.TbItemMapper;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LGCN
 */
@Service
public class ItemServiceImpl implements ItemService {

   @Autowired
    private  TbItemMapper itemMapper;

    @Override
    public EasyUIDataGridResult<TbItem> findAllTbItem(Integer page, Integer row) {
        //设置分页信息的初始值。
        if (page ==null || page <0){
            page =1;
        }
        if (row ==null || row <0){
            row =30;
        }
        PageHelper.startPage(page,row);
        //设置查询条件
        TbItemExample example = new TbItemExample();
        //调用方法。
        List<TbItem> items = itemMapper.selectByExample(example);
        //获得分页信息
        PageInfo<TbItem> info = new PageInfo(items);
        //数据封装。
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        return result;
    }
}
