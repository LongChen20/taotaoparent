package com.taotao.service;

import com.taotao.common.EasyUIDataGridResult;
import com.taotao.entity.TbItem;

public interface ItemService {

    /**
     * 分页查询所有数据。
     * @param page 当前的页码
     * @param row 显示的行数集合
     * @return
     */
    EasyUIDataGridResult findAllTbItem(Integer page,Integer row);

}
