package com.example.demo;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SpringBootTest
@MapperScan(basePackages = {"com.example.demo.mapper"})
class DemoApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void saveOrder(){
        try{
            for (int i=1;i<=16;i++) {
                OrderEntity entity = new OrderEntity();
                entity.setUser_id(i);
                int flag = orderService.save(entity);
                if(flag>0){
                    System.out.println("保存成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getOrderById(){
        List<HashMap<String,Object>> list = orderService.getOrder();
        list.forEach(m-> System.out.println(m));
    }

}
