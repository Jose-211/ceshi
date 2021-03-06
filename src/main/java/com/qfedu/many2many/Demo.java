package com.qfedu.many2many;

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
    public static void findById1(){
        SqlSession session = factory.openSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student byId = mapper.findById(2);
        List<Course> courseList = byId.getCourseList();
        for (Course course : courseList) {
            System.out.println(course);
        }
        session.commit();
        session.close();
    }public static void findBySid(){
        SqlSession session = factory.openSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student byId = mapper.findById1(2);
        List<Course> courseList = byId.getCourseList();
        for (Course course : courseList) {
            System.out.println(course);
        }
        session.commit();
        session.close();
    }
    public static void findCid(){
        SqlSession sqlSession = factory.openSession();
        CourseDao mapper = sqlSession.getMapper(CourseDao.class);
        Course cid = mapper.findCid(2);
        List<Student> stuList = cid.getStuList();
        for (Student student : stuList) {
            System.out.println(student);
        }
    }
    public static void findByCid(){
        SqlSession sqlSession = factory.openSession();
        CourseDao mapper = sqlSession.getMapper(CourseDao.class);
        Course cid1 = mapper.findCid1(2);
        List<Student> stuList = cid1.getStuList();
        for (Student student : stuList) {
            System.out.println(student);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    public static void main(String[] args) {
        findByCid();
    }



    }

