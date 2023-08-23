package com.powernode;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
             sqlSession = build.openSession();
             sqlSession.insert("insertCar");
             sqlSession.commit();
        } catch (IOException e) {
            if(sqlSession!=null){
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
