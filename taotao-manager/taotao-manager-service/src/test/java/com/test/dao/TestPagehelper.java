package com.test.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.entity.TbItem;
import com.taotao.entity.TbItemExample;
import com.taotao.mapper.TbItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TestPagehelper {

    @Resource(name = "tbItemMapper")
    TbItemMapper itemMapper;

    @Test
    public void testfindAll(){
        TbItemExample example = new TbItemExample();
        //紧跟着的第一个会分页，后面失效。
        PageHelper.startPage(1,5);
        List<TbItem> items = itemMapper.selectByExample(example);
        List<TbItem> items1 = itemMapper.selectByExample(example);
        PageInfo<TbItem> info = new PageInfo<>(items);

        System.out.println("第一个是："+items.size());
        System.out.println("第二个是："+items1.size());

    }

}
