package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {
    @Test
    public void testEnvironment() throws IOException {
        //获取SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //这种方式是获取的默认环境
        SqlSessionFactory   sqlSessionFactory= sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("car.insertCar");
        sqlSession.commit();
        sqlSession.close();

        //这种方式就是通过环境id来使用指定的环境
        SqlSessionFactory sqlSessionFactory2 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "java_user");
        SqlSession sqlSession1 = sqlSessionFactory2.openSession();
        sqlSession1.insert("car.insertUser");
        sqlSession1.commit();
        sqlSession1.close();
    }
}
