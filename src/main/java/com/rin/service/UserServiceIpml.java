package com.rin.service;

import com.rin.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIpml implements UserService {

    private JdbcTemplate jdbcTemplate;

    public UserServiceIpml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update("insert into USER(NAME, AGE, email, modify_datetime) values(?, ?, ?, NOW())",
                user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public List<User> getUser(int id) {
        List<User> users = jdbcTemplate.query("select NAME, AGE, email from USER where id = ?", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }, id);
        return users;
    }

    @Override
    public int deleteUser(int id) {
        return jdbcTemplate.update("delete from USER where id = ?", id);
    }

    @Override
    public int getAllUser() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public List<User> getList() {
        List<User> users = jdbcTemplate.query("select NAME, AGE, email from USER", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            user.setEmail(resultSet.getString("email"));
            return user;
        });
        return users;
    }

    @Override
    public int updateUser(int id, User user) {
        return jdbcTemplate.update("update USER set NAME=?,AGE=?,email=? where id = ?",
                user.getName(), user.getAge(), user.getEmail(), id);
    }
}
