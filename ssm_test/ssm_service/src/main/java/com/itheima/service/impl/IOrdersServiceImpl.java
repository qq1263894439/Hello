package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao dao;
    @Override
    public List<Orders> findAll(Integer page, Integer size) throws Exception {
        //参数pageNum是页码值,pageSize是每页显示条数
        PageHelper.startPage(page,size);
        return dao.findAll();
    }
}
