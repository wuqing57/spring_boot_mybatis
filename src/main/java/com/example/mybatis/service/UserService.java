package com.example.mybatis.service;

import com.example.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(@Param("id") Long id);

    void insert(User user, @Param("name")String name, @Param("password") String password);

    void update(User user);

    void delete(@Param("id") Long id);

}
