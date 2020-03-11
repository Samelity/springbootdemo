package com.rin;

import com.rin.entity.User;
import com.rin.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JDBCTest {

    @Autowired
    private UserService userSerivce;

    @Test
    public void test() throws Exception {
        /*
        // 插入5个用户
        userSerivce.createUser("Tom", 10, "xxx@11.com");
        userSerivce.createUser("Mike", 11,"");
        userSerivce.createUser("Didispace", 30,"");
        userSerivce.createUser("Oscar", 21,"");
        userSerivce.createUser("Linda", 17,"");

        // 查询名为Oscar的用户，判断年龄是否匹配
        List<User> userList = userSerivce.getUser("Oscar");
        Assertions.assertEquals(21, userList.get(0).getAge().intValue());

        // 查数据库，应该有5个用户
        Assertions.assertEquals(5, userSerivce.getAllUser());

        // 删除两个用户
        userSerivce.deleteUser("Tom");
        userSerivce.deleteUser("Mike");

        // 查数据库，应该有5个用户
        Assertions.assertEquals(3, userSerivce.getAllUser());
        */
    }

}
