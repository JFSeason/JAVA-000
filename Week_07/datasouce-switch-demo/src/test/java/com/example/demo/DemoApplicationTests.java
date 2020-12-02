package com.example.demo;

import com.example.demo.entity.SysUser;
import com.example.demo.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ISysUserService userService;

    @Test
    void contextLoads() {
        SysUser user = userService.getById(1);
        log.info(user.toString());
    }

    @Test
    public void test() {
        SysUser user = userService.findUserByFirstDb(1);
        log.info("第一个数据库 : [{}]", user.toString());
        SysUser user2 = userService.findUserBySecondDb(1);
        log.info("第二个数据库 : [{}]", user2.toString());
    }

}
