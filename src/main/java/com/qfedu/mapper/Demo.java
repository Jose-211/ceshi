package com.qfedu.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Demo {
    private static SqlSessionFactory factory = null;

    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resourceAsReader);

    }

    public static void findAll() {
        SqlSession session = factory.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        findAll();
    }
}