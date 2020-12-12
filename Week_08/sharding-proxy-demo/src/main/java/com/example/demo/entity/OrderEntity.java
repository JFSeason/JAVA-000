package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @date 2020/12/12 19:10
 */
@Data
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = -81849676368907419L;
    private Integer order_id;
    private Integer user_id;
}
