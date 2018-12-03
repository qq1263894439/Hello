package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao dao;
    @Override
    public List<Product> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(Product product) throws Exception{
        dao.save(product);
    }

}
