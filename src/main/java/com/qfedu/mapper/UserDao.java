package com.qfedu.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from  user")
    public List<User> findAll();
}
