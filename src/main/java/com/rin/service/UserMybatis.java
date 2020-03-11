package com.rin.service;

import com.rin.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMybatis {

    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);
}
