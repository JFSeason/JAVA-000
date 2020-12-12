package com.example.demo.mapper;

import com.example.demo.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author
 * @date 2020/12/12 22:06
 */
@Repository
public interface OrderMapper {

    int save(@Param("order") OrderEntity order);

    List<HashMap<String,Object>> getOrder();

}
