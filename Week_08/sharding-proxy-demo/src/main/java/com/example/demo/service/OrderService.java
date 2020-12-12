package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author
 * @date 2020/12/13 0:11
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public int save(OrderEntity entity){
        return this.orderMapper.save(entity);
    }

    public List<HashMap<String,Object>> getOrder() {
        return this.orderMapper.getOrder();
    }
}
