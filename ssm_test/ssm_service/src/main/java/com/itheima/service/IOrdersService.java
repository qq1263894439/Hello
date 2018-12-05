package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(Integer page,Integer size) throws Exception;
    Orders findById(String id) throws Exception;
}
