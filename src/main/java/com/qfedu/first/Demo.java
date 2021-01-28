/*
package com.qfedu.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo {
    public static void main(String[] args) {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            SqlSession session = factory.openSession();
            session.insert("userMapper.add");
            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
