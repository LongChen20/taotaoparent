package com.taotao.service.impl;

import com.taotao.mapper.DemoMapper;
import com.taotao.service.DemoDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LGCN
 */
@Service
public class DemoDateServiceImpl implements DemoDateService {

    /**
     * 注入mapper
     */
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public String demodate() {
        return  demoMapper.DemoDate();
    }
}
